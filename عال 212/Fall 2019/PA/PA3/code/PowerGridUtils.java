public class PowerGridUtils {

	// Return the IDs of all elements in the power grid pg in pre-order.
	public static Queue<Integer> collectPreorder(GT<PGElem> pg);

	// Searches the power grid pg for the element with ID id. If found, it is made current and true is returned, otherwise false is returned.
	public static boolean find(GT<PGElem> pg, int id);

	// Add the generator element gen to the power grid pg. This can only be done if the grid is empty. If successful, the method returns true. If there is already a generator, or gen is not of type Generator, false is returned.
	public static boolean addGenerator(GT<PGElem> pg, PGElem gen);

	// Attaches pgn to the element id and returns true if successful. Note that a consumer can only be attached to a transmitter, and no element can be be attached to it. The tree must not contain more than one generator located at the root. If id does not exist, or there is already aelement with the same ID as pgn, pgn is not attached, and the method retrurns false.
	public static boolean attach(GT<PGElem> pg, PGElem pgn, int id);

	// Removes element by ID, all corresponding subtree is removed. If removed, true is returned, false is returned otherwise.
	public static boolean remove(GT<PGElem> pg, int id);

	// Computes total power that consumed by a element (and all its subtree). If id is incorrect, -1 is returned.
	public static double totalPower(GT<PGElem> pg, int id);

	// Checks if the power grid contains an overload. The method returns the ID of the first element preorder that has an overload and -1 if there is no overload.
	public static int findOverload(GT<PGElem> pg);
}
