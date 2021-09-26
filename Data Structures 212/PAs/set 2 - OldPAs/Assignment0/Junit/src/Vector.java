
public class Vector {

		private int [] values ;
		private int size ;
		public Vector ( int size ) {
		this.size = size ;
		values = new int [ size ];
		}
		public void set ( int i, int val) {
		values [i] = val ;
		}
		
		public int get( int i) {
		return values [i];
		}
		
		public int sum () {
		int s = 0;
		for ( int i = 0; i < size ; i++) {
		s += values [i];
		}
		return s;
		}
		
		public int prod () {
			int p = 1;
			for ( int i = 0; i < size ; i++) {
			p *= values [i];
			}
			return p;
			}
			public double average () {
			return (double) sum () / ( size );
			}
			
			public int count(int m){
				int count=0;
				for (int i=0; i<size ; i++)
					if(values [i] == m)
						count++;
				
				return count;
			}
}
