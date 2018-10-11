package Two.LatterTerm.DataStructurePractice.ex5;

public class MyStack {
    private String[] stack; // 要素を入れる配列
    private int sp;       // 空き場所を指すインデックス
    private static final int MAX_SIZE = 10; // スタックの最大サイズ

    public MyStack() {
        // スタック用配列の初期化
        stack = new String[MAX_SIZE];
        // スタックポインタの初期化
        sp = 0;
    }

    public void push(String str) {
        // 最大サイズを超えていたらエラー表示をして抜ける
        if (sp >= MAX_SIZE) {
            System.out.println("これ以上は値を格納することができません");
            return;
        }
        // push の処理
        stack[sp] = str;
        sp += 1;

    }

    public String pop() {
        // スタックが空ならエラーを表示して，null を返す
        if (sp <= 0) {
            System.out.println("要素がないためpopは出来ません");
            return null;
        }
        // pop の処理
        String re;
        sp -= 1;
        re = stack[sp];
        stack[sp] = null;
        return re;
    }

    public String peek() {
        // スタックが空ならエラーを表示して，null を返す
        if (sp <= 0) {
            System.out.println("要素がないためpeekは出来ません");
            return null;
        }
        // peek の処理
        return stack[sp-1];
    }

    public boolean empty() {
        // スタックが空かどうかを返す
        if (sp <= 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        // スタックの文字列表現
        String str = "aMyStack(";
        for (int i = 0; i < sp; i++) {
            str = str + stack[i] + " ";
        }
        str = str + ")";
        return str;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        System.out.println("スタックにプッシュ");
        System.out.println(stack);
        stack.push("abc");
        stack.push("def");
        stack.push("ghi");
        stack.push("jkl");
        System.out.println(stack);
        stack.push("mno");
        stack.push("pqr");
        System.out.println(stack);
        System.out.println("peekしてみる: " + stack.peek());
        System.out.println("スタックからポップ");
        while (!stack.empty()) {
            System.out.println(stack.pop() + "を取り出した．");
            System.out.println(stack);
        }
        // 以下はエラーチェック用
        System.out.println("エラーを出してみる．");
        System.out.println(stack);
        stack.pop();       // 空のはずなのにpop!
        stack.peek();      // 空のはずなのにpeek!
        System.out.println(stack);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        System.out.println(stack);
        stack.push("10");
        System.out.println(stack);
        stack.push("11");       // 一杯なはずなのにpush!
        System.out.println(stack);
    }
}
