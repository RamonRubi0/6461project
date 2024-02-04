package csci6461_team8.assembler;

import java.util.HashMap;
import java.util.Map;

public class Assembler {
    private static Map<String, String> mnemonicBinaryOpcodeMapper;

    static{
        mnemonicBinaryOpcodeMapper = new HashMap<>();

        // Miscellaneous Instruction
        mnemonicBinaryOpcodeMapper.put("HLT", "000000");
        //mnemonicBinaryOpcodeMapper.put("", "");

        // Load/Store Instructions
        mnemonicBinaryOpcodeMapper.put("LDR", "000001"); // load register from memory
        mnemonicBinaryOpcodeMapper.put("STR", "000010"); // store register to memory
        mnemonicBinaryOpcodeMapper.put("LDA", "000011"); // load register with address
        mnemonicBinaryOpcodeMapper.put("LDX", "000100"); // load index register from memory
        mnemonicBinaryOpcodeMapper.put("STX", "000101"); // store index register to memory

        // Transfer Instructions
        mnemonicBinaryOpcodeMapper.put("SETCCE", "100100"); // set condition code E
        mnemonicBinaryOpcodeMapper.put("JZ", "000110"); // jump if zero
        mnemonicBinaryOpcodeMapper.put("JNE", "000111"); // jump if not equal
        mnemonicBinaryOpcodeMapper.put("JCC", "001000"); // jump if condition code
        mnemonicBinaryOpcodeMapper.put("JMA", "001001"); // unconditional jump to address
        mnemonicBinaryOpcodeMapper.put("JSR", "001010"); // jump and save return address
        mnemonicBinaryOpcodeMapper.put("RFS", "001011"); // return from subroutine
        mnemonicBinaryOpcodeMapper.put("SOB", "001100"); // subtract one and branch
        mnemonicBinaryOpcodeMapper.put("JGE", "001101"); // jump greater than or equal to

        // Arithmetic and Logical Instruction
        mnemonicBinaryOpcodeMapper.put("AMR", "001110"); // add memory to register
        mnemonicBinaryOpcodeMapper.put("SMR", "001111"); // subtract memory from register
        mnemonicBinaryOpcodeMapper.put("AIR", "010000"); // add immediate to register
        mnemonicBinaryOpcodeMapper.put("SIR", "010001"); // subtract immediate from register
        mnemonicBinaryOpcodeMapper.put("MLT", "010010"); // multiply register by register
        mnemonicBinaryOpcodeMapper.put("DVD", "010011"); // divide register by register
        mnemonicBinaryOpcodeMapper.put("TRR", "010100"); // test the equity of register and register
        mnemonicBinaryOpcodeMapper.put("AND", "010101"); // logical and of register and register
        mnemonicBinaryOpcodeMapper.put("ORR", "010110"); // logical or of register and register
        mnemonicBinaryOpcodeMapper.put("NOT", "010111"); // logical not of register to register
        mnemonicBinaryOpcodeMapper.put("SRC", "011000"); // shift register by count
        mnemonicBinaryOpcodeMapper.put("RRC", "011001"); // rotate register by count

        // I/O Operations
        mnemonicBinaryOpcodeMapper.put("IN", "011010"); // input character to register from device
        mnemonicBinaryOpcodeMapper.put("OUT", "011011"); // output character to device from register
        mnemonicBinaryOpcodeMapper.put("CHK", "011100"); // check device status to register
    }

    private static Map<String, String> registerDecBinMapper;

    static{
        registerDecBinMapper = new HashMap<>();

        registerDecBinMapper.put("0", "00");
        registerDecBinMapper.put("1", "01");
        registerDecBinMapper.put("2", "10");
        registerDecBinMapper.put("3", "11");
    }

    private static Map<String, String> addressDecBinMapper;

    static{
        addressDecBinMapper = new HashMap<>();
        addressDecBinMapper.put("0",  "00000");
        addressDecBinMapper.put("1",  "00001");
        addressDecBinMapper.put("2",  "00010");
        addressDecBinMapper.put("4",  "00100");
        addressDecBinMapper.put("5",  "00101");
        addressDecBinMapper.put("6",  "00110");
        addressDecBinMapper.put("7",  "00111");
        addressDecBinMapper.put("8",  "01000");
        addressDecBinMapper.put("9",  "01001");
        addressDecBinMapper.put("10", "01010");
        addressDecBinMapper.put("11", "01011");
        addressDecBinMapper.put("12", "01100");
        addressDecBinMapper.put("13", "01101");
        addressDecBinMapper.put("14", "01110");
        addressDecBinMapper.put("15", "01111");
        addressDecBinMapper.put("16", "10000");
        addressDecBinMapper.put("17", "10001");
        addressDecBinMapper.put("18", "10010");
        addressDecBinMapper.put("19", "10011");
        addressDecBinMapper.put("20", "10100");
        addressDecBinMapper.put("21", "10101");
        addressDecBinMapper.put("22", "10110");
        addressDecBinMapper.put("23", "10111");
        addressDecBinMapper.put("24", "11000");
        addressDecBinMapper.put("25", "11001");
        addressDecBinMapper.put("26", "11010");
        addressDecBinMapper.put("27", "11011");
        addressDecBinMapper.put("28", "11100");
        addressDecBinMapper.put("29", "11101");
        addressDecBinMapper.put("30", "11110");
        addressDecBinMapper.put("31", "11111");
    }

    public static String assemblyToBinaryMachineCode(String assembly){

        String[] assemblyComponents = assembly.split("[,\\s]+"); // spilt the textual assembly by ' ' and ','
        int assemblyComponentsNum = assemblyComponents.length;
        String mnemonicString = assemblyComponents[0]; // the first component is the mnemonic
        String BinaryOpcodeString = mnemonicBinaryOpcodeMapper.get(mnemonicString); // binary form of the mnemonic
        int operationInteger = Integer.parseInt(BinaryOpcodeString, 2);

        StringBuilder binaryMachineCodeBuilder;
        switch (operationInteger){
            case 0: // HLT
                return "0000000000000000";

            case 1: // LDR r,x,address[,I] (load register from memory)
                    // Opcode R  IX I Address
                    // xxxxxx xx xx x xxxxx

            case 2: // STR r,x,address[,I] (store register memory)
                    // Opcode R  IX I Address
                    // xxxxxx xx xx x xxxxx

            case 3: // LDA r,x,address[,I] (load register with address)
                    // Opcode R  IX I Address
                    // xxxxxx xx xx x xxxxx

            case 7: // JNE r,x,address[,I] (jump if not equal)
                    // Opcode R  IX I Address
                    // xxxxxx xx xx x xxxxx

            case 8: // JCC cc,x,address[,I] (jump if condition code)
                    // Opcode cc IX I Address
                    // xxxxxx xx xx x xxxxx

            case 12: // SOB r,x,address[,I] (subtract one and branch)
                    // Opcode r  IX I Address
                    // xxxxxx xx xx x xxxxx

            case 13: // SOB r,x,address[,I] (subtract one and branch)
                // Opcode r  IX I Address
                // xxxxxx xx xx x xxxxx

                binaryMachineCodeBuilder = new StringBuilder();
                binaryMachineCodeBuilder.append(BinaryOpcodeString); // append binary opcode
                binaryMachineCodeBuilder.append(registerDecBinMapper.get(assemblyComponents[1])); // append binary general register
                binaryMachineCodeBuilder.append(registerDecBinMapper.get(assemblyComponents[2])); // append binary index register
                if(assemblyComponentsNum == 5){ // I field exists
                    binaryMachineCodeBuilder.append("1");
                } else {
                    binaryMachineCodeBuilder.append("0");
                } // append I
                binaryMachineCodeBuilder.append(addressDecBinMapper.get(assemblyComponents[3])); // append binary address
                return binaryMachineCodeBuilder.toString();

            case 4: // LDX x,address[,I] (load index register from memory)
                    // Opcode R  IX I Address
                    // xxxxxx xx xx x xxxxx

            case 5: // STX x,address[,I] (store index register to memory)
                    // Opcode R  IX I Address
                    // xxxxxx xx xx x xxxxx

            case 6: // JZ x,address[,I] (jump if zero)
                    // Opcode R  IX I Address
                    // xxxxxx xx xx x xxxxx

            case 9: // JMA x,address[,I] (unconditional jump to address)
                    // Opcode R  IX I Address
                    // xxxxxx xx xx x xxxxx

            case 10: // JSR x,address[,I] (jump and save return address)
                    // Opcode R  IX I Address
                    // xxxxxx xx xx x xxxxx

                binaryMachineCodeBuilder = new StringBuilder();
                binaryMachineCodeBuilder.append(BinaryOpcodeString); // append binary opcode
                binaryMachineCodeBuilder.append("00"); // no regular register, filled with "00"
                binaryMachineCodeBuilder.append(registerDecBinMapper.get(assemblyComponents[1])); // append binary index register
                if(assemblyComponentsNum == 4){ // I field exists
                    binaryMachineCodeBuilder.append("1");
                } else {
                    binaryMachineCodeBuilder.append("0");
                } // append I
                binaryMachineCodeBuilder.append(addressDecBinMapper.get(assemblyComponents[2])); // append binary address
                return binaryMachineCodeBuilder.toString();

            case 36: // SETCCE r (set the E bit of condition code)
                     // Opcode R  IX I Address
                     // xxxxxx xx xx x xxxxx
                binaryMachineCodeBuilder = new StringBuilder();
                binaryMachineCodeBuilder.append(BinaryOpcodeString); // append binary opcode
                binaryMachineCodeBuilder.append(registerDecBinMapper.get(assemblyComponents[0])); // append binary regular register
                binaryMachineCodeBuilder.append("00000000"); // no IX, I, Address, filled with "00000000"


                binaryMachineCodeBuilder = new StringBuilder();
                binaryMachineCodeBuilder.append(BinaryOpcodeString); // append binary opcode
                binaryMachineCodeBuilder.append("00"); // no regular register, filled with "00"
                binaryMachineCodeBuilder.append(registerDecBinMapper.get(assemblyComponents[1])); // append binary index register
                if(assemblyComponentsNum == 4){ // I field exists
                    binaryMachineCodeBuilder.append("1");
                } else {
                    binaryMachineCodeBuilder.append("0");
                } // append I
                binaryMachineCodeBuilder.append(addressDecBinMapper.get(assemblyComponents[2])); // append binary address
                return binaryMachineCodeBuilder.toString();

        }
        return "";
    }

    public static void main(String[] args) {
        String test = "LDA 3,0,15";
        System.out.println(assemblyToBinaryMachineCode(test));
    }



}
