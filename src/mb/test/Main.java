package mb.test;

public class Main {

	public static void main(String[] args) {
		MyTree<String> baum1 = new MyTree<>("root");
		baum1.addChild("cats");
		baum1.addChild("dogs");
		baum1.children.get(0).addChild("Tama");
		baum1.children.get(1).addChild("Taro");
		
//		baum1.children.addChild()
		System.out.println(baum1.children.get(0).children);
		System.out.println(baum1.children.get(1).getChilden());
		
	}

}
