package stack;

public class BalancedParanthesis {

	public static Boolean BalanceCheck(String paranthesis) {
		Stack stack = new Stack();
		for (int i = 0; i < paranthesis.length(); i++) {
			if (paranthesis.charAt(i) == '{' || paranthesis.charAt(i) == '[' || paranthesis.charAt(i) == '(') {
				stack.push(String.valueOf(paranthesis.charAt(i)));
			} else {
				if (paranthesis.charAt(i) == '}' || paranthesis.charAt(i) == ']' || paranthesis.charAt(i) == ')') {
					if (stack.isEmpty())
						return false;
					else if (paranthesis.charAt(i) == '}') {
						if (stack.elementAtTop().equals("{")) {
							stack.pop();
							continue;
						} else
							return false;
					} else if (paranthesis.charAt(i) == ']') {
						if (stack.elementAtTop().equals("[")) {
							stack.pop();
							continue;
						} else
							return false;
					} else if (paranthesis.charAt(i) == ')') {
						if (stack.elementAtTop().equals("(")) {
							stack.pop();
							continue;
						} else
							return false;
					}

				} else
					return false;
			}
		}

		if (stack.isEmpty())
			return true;
		return false;

	}

	public static void main(String[] args) {
		if(BalanceCheck("{((([[[}]]][])))}"))
			System.out.println("String is balanced");
		else
			System.out.println("String is not balanced");

	}

}
