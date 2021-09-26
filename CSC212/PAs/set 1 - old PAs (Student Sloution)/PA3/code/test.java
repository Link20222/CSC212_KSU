
public class test {
public static void main (String[] args) {
	
	GT<PGElem> tree = new LinkedGT<PGElem>();
	
	PGElem gen = new PGElem(66, ElemType.Generator, 50);
	PGElem a = new PGElem(1, ElemType.Generator, 50);
	PGElem b = new PGElem(2, ElemType.Transmitter, 20);
	PGElem c = new PGElem(3, ElemType.Transmitter, 20);
	PGElem d = new PGElem(4, ElemType.Consumer, 5);
	PGElem e = new PGElem(5, ElemType.Consumer, 3);
	PGElem f = new PGElem(6, ElemType.Transmitter, 5);
	PGElem g = new PGElem(7, ElemType.Consumer, 11);
	PGElem h = new PGElem(8, ElemType.Consumer, 10);
	PGElem i = new PGElem(9, ElemType.Consumer, 7);
	
	System.out.println("-----------------");
	if (PowerGridUtils.addGenerator(tree, a) )
		System.out.println ("generator added");
	else
		System.out.println ("mistake");
	
	System.out.println("-----------------");
	
	if (PowerGridUtils.addGenerator(tree, gen) )
		System.out.println ("generator added");
	else
		System.out.println ("another generator .. mistake");
	
	System.out.println("-----------------");
	
	if (PowerGridUtils.addGenerator(tree, b) )
		System.out.println ("generator added");
	else
		System.out.println ("adding a transmitter .. mistake");
	System.out.println("-----------------");
	
	PowerGridUtils.attach(tree, b , 1);
	PowerGridUtils.attach(tree, c , 1);
	PowerGridUtils.attach(tree, d , 2);
	PowerGridUtils.attach(tree, e , 2);
	PowerGridUtils.attach(tree, f , 2);
	PowerGridUtils.attach(tree, g , 3);
	PowerGridUtils.attach(tree, h , 3);
	PowerGridUtils.attach(tree, i , 6);
	
	
	Queue<Integer> q = PowerGridUtils.collectPreorder(tree);
	System.out.println("-----------------");
	
	System.out.println(q.length()); // 9 
	for (int k = 0 ; k <q.length() ; k++) {
		int x = q.serve();
		System.out.println(x);
		q.enqueue(x);
	} // 1 2 4 5 6 9 3 7 8 
	
	
	System.out.println("-----------------");
	
	boolean find = PowerGridUtils.find(tree,5);
	System.out.println (find);
	System.out.println (tree.retrieve().getId());
	
	find = PowerGridUtils.find(tree,99);
	System.out.println (find);
	System.out.println (tree.retrieve().getId());
	
	System.out.println("-----------------");
	
	System.out.println ( PowerGridUtils.totalPower(tree, 2) ); //15
	
	System.out.println ( PowerGridUtils.totalPower(tree, 3) ); //21
	System.out.println ( PowerGridUtils.totalPower(tree, 11) ); //-1
	
	System.out.println("-----------------");
	
	
	System.out.println ( PowerGridUtils.findOverload(tree) ); //6 .. 6 and 3 both overloaded but 6 comes before in preorder
    
	System.out.println("-----------------");
	
	if (PowerGridUtils.remove(tree, 3))
		System.out.println ( "done" );
	else
		System.out.println("mistakee");
	
	q = PowerGridUtils.collectPreorder(tree);
	
	System.out.println("-----------------");
	
	System.out.println(q.length());
	for (int k = 0 ; k <q.length() ; k++) {
		int x = q.serve();
		System.out.println(x);
		q.enqueue(x);
	}
	
}
}
