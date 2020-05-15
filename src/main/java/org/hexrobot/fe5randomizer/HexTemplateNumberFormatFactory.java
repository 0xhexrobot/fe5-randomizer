package org.hexrobot.fe5randomizer;

import java.util.Locale;

import freemarker.core.Environment;
import freemarker.core.InvalidFormatParametersException;
import freemarker.core.TemplateFormatUtil;
import freemarker.core.TemplateNumberFormat;
import freemarker.core.TemplateNumberFormatFactory;
import freemarker.core.UnformattableValueException;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;
import freemarker.template.utility.NumberUtil;

public class HexTemplateNumberFormatFactory extends TemplateNumberFormatFactory {
    public static final HexTemplateNumberFormatFactory INSTANCE = new HexTemplateNumberFormatFactory();
    
    private HexTemplateNumberFormatFactory() {
    }

    @Override
    public TemplateNumberFormat get(String params, Locale locale, Environment env)
            throws InvalidFormatParametersException {
        int minZeroes = 0;
        
        if(!params.isEmpty()) {
            minZeroes = Integer.parseInt(params);
        }
        
        return new HexTemplateNumberFormat(minZeroes);
    }

    private static class HexTemplateNumberFormat extends TemplateNumberFormat {
        int minZeroes;
        
        private HexTemplateNumberFormat(int minZeroes) {
            this.minZeroes = minZeroes;
        }

        @Override
        public String formatToPlainText(TemplateNumberModel numberModel)
                throws UnformattableValueException, TemplateModelException {
            Number n = TemplateFormatUtil.getNonNullNumber(numberModel);
            try {
                String result = Integer.toHexString(NumberUtil.toIntExact(n)).toUpperCase(); 
                
                if(minZeroes > 0) {
                    result = String.format("0x%0" + minZeroes + "X", NumberUtil.toIntExact(n));
                }
                
                return result;
            } catch(ArithmeticException e) {
                throw new UnformattableValueException(n + " doesn't fit into an int");
            }
        }

        @Override
        public boolean isLocaleBound() {
            return false;
        }

        @Override
        public String getDescription() {
            return "hexadecimal int";
        }
    }
}
