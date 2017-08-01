
public class MyLinkedListTester 
{
	public static void main (String [] args)
	{
		MyLinkedList list = new MyLinkedList<>();
		list.add("bob");
		list.add("tom");
		list.add("joe");
		list.add("andy");
		list.add("maria");
		list.add("steve");
		list.add("tom");
		list.add("steve");
		
		System.out.println(list.toString());
	
		System.out.println("Expected: (bob), Actual: "+list.getNodeAt(1));
		System.out.println("Expected: (steve), Actual: "+ list.getNodeAt(5));
		
		System.out.println("Expected: bob, Actual: "+ list.get(1));
		System.out.println("Expected: null, Actual: "+ list.get(6));
		
		System.out.println("Expected: 0, Actual: "+ list.indexOf("bob"));
		System.out.println("Expected: 1, Actual: " + list.indexOf("tom"));
		System.out.println("Expected: -1, Actual: " + list.indexOf("rishabh"));
		
		System.out.println("Expected: 6, Actual: " + list.lastIndexOf("tom"));
		System.out.println("Expected: 7, Actual: " + list.lastIndexOf("steve"));
		System.out.println("Expected: -1, Actual: " + list.lastIndexOf("rishabh"));

		System.out.println("Expected: true, Actual: " + list.contains("tom"));
		System.out.println("Expected: true, Actual: " + list.contains("bob"));
		System.out.println("Expected: true, Actual: " + list.contains("joe"));
		System.out.println("Expected: true, Actual: " + list.contains("andy"));
		System.out.println("Expected: true, Actual: " + list.contains("maria"));
		System.out.println("Expected: true, Actual: " + list.contains("steve"));
		System.out.println("Expected: false, Actual: " + list.contains("rishabh"));
		
		System.out.println("Expected: true, Actual: " + list.remove("steve"));

		System.out.println(list.toArray());
	}
	
	
			
	
}
