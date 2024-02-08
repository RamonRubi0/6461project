package csci6461_team8.assembler;

public class PosNotationTools {
    public static String binStrFromDecStr(String decStr, int binStrLen){
        int decInteger =  Integer.parseInt(decStr);
        String binStr = Integer.toBinaryString(decInteger);
        int leadingZerosNum = binStrLen - binStr.length();
        if(leadingZerosNum > 0){
            StringBuilder leadingZerosBuilder = new StringBuilder();
            for(int i = 0; i < leadingZerosNum; i++){
                leadingZerosBuilder.append('0');
            }
            binStr = leadingZerosBuilder.toString() + binStr;
        }
        return binStr;
    }

    public static String octStrFromBinStr(String binStr, int octStrLen){
        binStr = binStr.replaceFirst("^0+", ""); // remove leading zeros
        int binStrLen = binStr.length();
        int octStrWithoutLeadingZerosLen = binStrLen / 3 + (binStrLen % 3 != 0 ? 1 : 0);
        int leadingZerosNum = octStrLen -  octStrWithoutLeadingZerosLen;
        char[] octCharArr = new char[octStrLen];
        for(int i = 0; i < leadingZerosNum; i++){
            octCharArr[i] = '0';
        }
        for(int i = 0, j = binStrLen - 1; i < octStrWithoutLeadingZerosLen; i++){
            int oneDigit = Character.getNumericValue(binStr.charAt(j));
            if(j >= 1){
                oneDigit += 2 * Character.getNumericValue(binStr.charAt(j - 1));
            }
            if(j >= 2){
                oneDigit += 4 * Character.getNumericValue(binStr.charAt(j - 2));
            }
            octCharArr[octStrLen - 1 - i] = Character.forDigit(oneDigit,8);
            j -= 3;
        }
        return new String(octCharArr);
    }

    public static String octStrFromInteger(int x, int octStrLen){
        String octStr = Integer.toOctalString(x);
        int leadingZerosNum = octStrLen - octStr.length();
        if(leadingZerosNum > 0){
            StringBuilder leadingZerosBuilder = new StringBuilder();
            for(int i = 0; i < leadingZerosNum; i++){
                leadingZerosBuilder.append('0');
            }
            octStr = leadingZerosBuilder.toString() + octStr;
        }
        return octStr;
    }
}
