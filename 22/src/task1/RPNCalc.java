package task1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Stack;

public class RPNCalc {

    public enum RPNMode {
        RAD, DEG
    };

    public enum DispMode {
        STD, FIX, SCI, ENG
    };

    public enum Ops {
        ADD, // calculates y+x
        CLEAR, // clears stack
        DELETE, // discards last element
        DIV, // calculates y/x
        DUP, // duplicates the last element
        MULT, // calculates y*x
        POW, // calculates y^x
        ROT, // rotate stack by x
        STD, // selects standard display mode
        SUBT, // calculates y-x
    }
    private final String ERR_NO_STACK = "Недостаточно элементов для стека!";
    private final String ERR_OVERFLOW = "Переполнение";
    private final String ERR_UNKNOWN_OP = "Неизвестная операция";
    private final String ERR_NEED_INT = "Последний элемент должен быть числом";
    private final String ERR_NOT_IMPL = "Операция не сделана";
    private final String ERR_DIV_BY_ZERO = "Деление на ноль";
    private final String ERR_UNKNOWN_ERR = "Неизвестная ошибка";
    private Stack<BigDecimal> rpnstack;
    private HashMap<String, Ops> cmdmap;
    private HashMap<String, BigDecimal> constmap;
    private DispMode disp_mode;
    private int disp_prec; // the display precision.

    public RPNCalc() {
        rpnstack = new Stack<BigDecimal>();

        cmdmap = new HashMap<String, Ops>();
        cmdmap.put("*", Ops.MULT);
        cmdmap.put("+", Ops.ADD);
        cmdmap.put("-", Ops.SUBT);
        cmdmap.put("/", Ops.DIV);
        cmdmap.put("^", Ops.POW);
        cmdmap.put("c", Ops.CLEAR);
        cmdmap.put("del", Ops.DELETE);
        cmdmap.put("dup", Ops.DUP);
        cmdmap.put("pow", Ops.POW);
        cmdmap.put("rot", Ops.ROT);
        cmdmap.put("std", Ops.STD);

        constmap = new HashMap<String, BigDecimal>();
        constmap.put("E", new BigDecimal(Math.E));
        constmap.put("PI", new BigDecimal(Math.PI));

        disp_mode = DispMode.STD;
    }

    public boolean doOperation(Ops op) throws ArithmeticException {
        switch (op) {
            case ADD:
                requireStack(2);
                push(pop().add(pop()));
                return true;
            case CLEAR:
                requireStack(1);
                rpnstack.removeAllElements();
                return true;
            case DELETE:
                if (rpnstack.size() >= 1) {
                    rpnstack.pop();
                    return true;
                }
                return false;
            case DIV:
                requireStack(2);
            {
                BigDecimal x = pop();
                if (x.equals(BigDecimal.ZERO))
                {
                    throw new ArithmeticException(ERR_DIV_BY_ZERO);
                }
                push(pop().divide(x, MathContext.DECIMAL128));
            }
            return true;
            case DUP:
                requireStack(1);
                push(new BigDecimal(peek().toString()));
                return true;
            case MULT:
                requireStack(2);
                push(pop().multiply(pop()));
                return true;
            case POW:
                requireStack(2);
                if (peekInteger()) {
                    int ivaluex = pop().intValueExact();
                    push(pop().pow(ivaluex));
                } else {
                    double dvaluex = pop().doubleValue();
                    double dvaluey = pop().doubleValue();
                    push(new BigDecimal(Math.pow(dvaluey, dvaluex)));
                }
                return true;
            case ROT:
                requireStack(3);
                BigDecimal value = rpnstack.remove(rpnstack.size() - 3);
                push(value);
                return true;
            case STD:
                disp_mode = DispMode.STD;
                return true;

            case SUBT:
                requireStack(2);
            {
                BigDecimal x = pop();
                push(pop().subtract(x));
            }
            return true;

            default:
                throw new ArithmeticException(ERR_UNKNOWN_OP);
        }
    }

    public void swap(int idx) throws ArithmeticException {
        requireStack(idx);

        if (idx == 0) {
            return;
        }

        BigDecimal nv = rpnstack.remove(idx);
        BigDecimal xv = rpnstack.pop();

        rpnstack.push(nv);
        rpnstack.insertElementAt(xv, idx);
    }

    public void push(BigDecimal val) {
        rpnstack.push(val);
    }

    public void push(long val) {
        rpnstack.push(new BigDecimal(val));
    }

    public void push(double val) {
        rpnstack.push(new BigDecimal(val));
    }

    public void push(String val) throws NumberFormatException {

        if (pushTextOp(val) || pushConstant(val)) {
            return;
        }

        rpnstack.push(new BigDecimal(val));
    }

    public boolean pushTextOp(String val) {
        Ops op = cmdmap.get(val);
        if (op != null) {
            doOperation(op);
            return true;
        }
        return false;
    }

    public boolean pushConstant(String val)
    {
        BigDecimal con = constmap.get(val);
        if (con != null) {
            push(con);
            return true;
        }
        return false;
    }

    public BigDecimal pop() {
        return rpnstack.pop();
    }

    public BigDecimal peek() {
        return rpnstack.peek();
    }

    public int getStackHeight() {
        return rpnstack.size();
    }


    public String getStackEntry(int i)
    {
        if (i >= rpnstack.size()) {
            return null;
        }

        BigDecimal val = rpnstack.elementAt(i).round(MathContext.DECIMAL64);
        int scale = val.scale();
        int digits = val.precision();

        switch (disp_mode) {
            case STD:
                return val.toString();

            case FIX:
                return val.toPlainString();

            case SCI:
                return val.setScale(-1, RoundingMode.HALF_EVEN).toString();

            case ENG:
                return val.toEngineeringString();

            default:
                return null;
        }
    }

    public Stack getStack() {
        return rpnstack;
    }


    @Override
    public String toString() {
        String output = "";
        for (int idx = 0; idx < rpnstack.size(); idx++) {
            output += new String((rpnstack.size() - idx) + ": " + rpnstack.elementAt(idx) + "\n");
        }

        return output;
    }

    private void requireStack(int i) throws ArithmeticException {
        if (rpnstack.size() < i) {
            throw new ArithmeticException(ERR_NO_STACK);
        }
    }

    private void requireInteger() throws ArithmeticException {
        if (peek().scale() > 0) {
            throw new ArithmeticException(ERR_NEED_INT);
        }
    }

    private boolean peekInteger() {
        return (peek().scale() <= 0);
    }
}
