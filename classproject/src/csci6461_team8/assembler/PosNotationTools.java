package csci6461_team8.assembler;
// utility methods for converting between different positional notations (binary and octal representations)
public class PosNotationTools {
    public static String binStrFromDecStr(String decStr, int binStrLen){
        // input: A decimal string decStr and the desired length of the binary string binStrLen
        int decInteger =  Integer.parseInt(decStr);
        String binStr = Integer.toBinaryString(decInteger); // Converts the decimal string to an integer
        int leadingZerosNum = binStrLen - binStr.length();
        if(leadingZerosNum > 0){
            StringBuilder leadingZerosBuilder = new StringBuilder();
            for(int i = 0; i < leadingZerosNum; i++){
                leadingZerosBuilder.append('0'); // Pads the binary string with zeros to match the desired length
            }
            binStr = leadingZerosBuilder.toString() + binStr;
        }
        // Output: Returns a binary string of length binStrLen representing the decimal value.
        return binStr;
    }

    public static String octStrFromBinStr(String binStr, int octStrLen){
        // Input: A binary string binStr and the desired length of the octal string octStrLen.
        binStr = binStr.replaceFirst("^0+", ""); // remove leading zeros
        int binStrLen = binStr.length();
        int octStrWithoutLeadingZerosLen = binStrLen / 3 + (binStrLen % 3 != 0 ? 1 : 0); // Divides the binary string into groups of three digits from right to left
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
        // Output: Returns an octal string of length octStrLen representing the binary value.
        return new String(octCharArr);
    }

    public static String octStrFromInteger(int x, int octStrLen){
        // Input: An integer x and the desired length of the octal string octStrLen.
        String octStr = Integer.toOctalString(x); // Converts the integer to an octal string.
        int leadingZerosNum = octStrLen - octStr.length();
        if(leadingZerosNum > 0){
            StringBuilder leadingZerosBuilder = new StringBuilder();
            for(int i = 0; i < leadingZerosNum; i++){
                leadingZerosBuilder.append('0');
            }
            octStr = leadingZerosBuilder.toString() + octStr; // Pads octal string with zeros to match the desired length
        }
        // Output: Returns an octal string of length octStrLen representing the integer value.
        return octStr;
    }
}
