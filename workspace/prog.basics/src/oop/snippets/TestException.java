package oop.snippets;

public class TestException {
	 static public float divide(float f1, float f2) {
		    if (f2==0) {
		    	throw new IllegalArgumentException("division by zero");
		    }		    
		    return f1 / f2;
		  }
	
	 public static void main(String args[]) {
		 
//		 float f1 = 1F;
//		 float f2 = 0F;
//		 float f = divide(f1,f2);
//		 System.out.println("f="+f);
		 
//		 float f1 = 1F;
//		    float f2 = 0F;
//		    try {
//		      float f = divide(f1,f2);
//		      System.out.println("f="+f);
//		    } catch (IllegalArgumentException ex) {
//		      System.err.println("An illegal argument was caught:");
//		      ex.printStackTrace(System.err);
//		      System.exit(-1);
//		    }
		    
	      compute(1F,0F,4F);
	  }

	  public static float compute(float f1, float f2, float f3) {
	    return f3*divide(f1,f2);
	  }

}
