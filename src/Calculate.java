import java.util.StringJoiner;

public class Calculate {

    private String arg1;
    private String arg2;
    private Operation op;
    private int arg2Nb;

    public void calculator(String s) throws MyExceptions {

        String operand = "\"";
        int nb0 = s.indexOf(operand);
        if (nb0 != 0) {
            throw new MyExceptions("Вы ввели число или неправильную строку! Строка должна быть в \" \" ");
        }
        int nb1 = s.indexOf(operand, nb0 + 1);
        arg1 = s.substring(nb0 + 1, nb1);

        if (arg1.length() > 10) {
            throw new MyExceptions("Первая строка больше 10 символов");
        }

        int nb2 = s.indexOf(" ", nb1 + 2);
        String operation = s.substring(nb1 + 2, nb2);

        int nb3 = s.indexOf(operand, nb2);
        if (nb3 != -1) {
            int nb4 = s.indexOf(operand, nb3 + 1);
            if (nb4 == -1) {
                throw new MyExceptions("Вы ввели неправильные значения");
            }
            arg2 = s.substring(nb3 + 1, nb4);

            if (arg2.length() > 10)
                throw new MyExceptions("Вторая строка больше 10 символов");
        } else {
            //int nb4 = s.indexOf("", nb2);
            arg2 = s.substring(nb2 + 1);
            arg2Nb = Integer.parseInt(arg2);
            if (arg2Nb > 10 || arg2Nb < 1)
                throw new MyExceptions("Число меньше 1 или больше 10");
        }

        if (operation.equals("+")) {
            if (arg2Nb != 0) throw new MyExceptions("Вторая строка не соответствует строке. Вы ввели число!");
            op = Operation.OP_PLUS;
        } else if (operation.equals("-")) {
            if (arg2Nb != 0) throw new MyExceptions("Вторая строка не соответствует строке. Вы ввели число!");
            op = Operation.OP_MIN;
        } else if (operation.equals("*")) {
            if (arg2Nb == 0) throw new MyExceptions("Вторая строка не соответствует числу");
            op = Operation.OP_MULT;
        } else if (operation.equals("/")) {
            if (arg2Nb == 0) throw new MyExceptions("Вторая строка не соответствует числу");
            op = Operation.OP_DIV;
        } else {
            throw new MyExceptions("Вы ввели неподходящую арифметическую операцию");
        }
    }


    public String calc() {

        String result = "";

        switch (op) {
            case OP_PLUS -> {
                result = arg1 + arg2;

            }
            case OP_MIN -> {
                result = arg1.replaceAll(arg2, "");

            }
            case OP_MULT -> {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < arg2Nb; i++) {
                    stringBuilder.append(arg1);
                }
                result = stringBuilder.toString();

                if (result.length() > 40) {
                    //"строка больше 40 символов";
                    result = result.substring(0, 40) + "...";

                }

            }
            case OP_DIV -> {
                int newSize = arg1.length() / arg2Nb;
                result = arg1.substring(0, newSize);

            }
        }
        StringJoiner stringJoiner = new StringJoiner("", "\"", "\"");
        stringJoiner.add(result);

        return stringJoiner.toString();
    }
}
