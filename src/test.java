
public class test {

	public static void main(String[] args) {

		Boolean flag = Boolean.TRUE;

		MyBoolean obj = new MyBoolean(flag);

		flag = Boolean.FALSE;

		System.out.println(obj.getValue());

	}

}

class MyBoolean {
	private Boolean value = null;

	public MyBoolean(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return this.value;
	}
}