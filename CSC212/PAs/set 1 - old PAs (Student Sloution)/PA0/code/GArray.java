class GArray<T> implements Separable<GArray<T>> {
	private T[] data;
	@SuppressWarnings("unchecked")
	public GArray(int n) {
		data = (T[]) new Object[n];
	}
	// Return the element at position i
	public T get(int i) {
		return data[i];
	}
	// Set the element at position i
	public void set(int i, T e) {
		data[i] = e;
	}
	@Override
	public int length() {
		return data.length; // Changed 1
	}
	@Override
	public GArray<T> first() {
		GArray<T> f = new GArray <T> (1);
      if (length() == 0)
         return f;
      f.set(0, data[0]);
      return f; // Changed 2
	}
	@Override
	public GArray<T> rest() {
      if (length() == 0){
      GArray<T> r = new GArray<T>(0);
      return r;
      }
		   GArray<T> rest = new GArray<T>(length()-1);
         for (int i=0; i<rest.length(); i++) {
           rest.set(i, data[i+1]);
       }
          return rest; } // Changed 3
	@Override
	public GArray<T> concat(GArray<T> s1, GArray<T> s2) {
		GArray<T> concat = new GArray <T> (s1.length()+s2.length());
      int i;
      for (i=0; i<s1.length(); i++){
         concat.set(i, s1.data[i]);
      }
      for (int j=0; j<s2.length(); j++){
         concat.set(i++, s2.data[j]);
      }
      return concat;
       // Changed 3
	}
}
