package object.classes.ex1;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Util {

  static void traceEnter() {
    Thread t = Thread.currentThread();
    StackTraceElement[] frames = t.getStackTrace();
    for (int i = 0; i < frames.length - 2; i++)
      System.out.print("-");
    StackTraceElement top = frames[2];
    String sig = top.getClassName() + ":" + top.getMethodName();
    String loc = top.getFileName() + ":" + top.getLineNumber();
    System.out.println(sig + " at " + loc);
  }

  static void traceLeave() {
    Thread t = Thread.currentThread();
    StackTraceElement[] frames = t.getStackTrace();
    for (int i = 0; i < frames.length-2; i++)
      System.out.print(".");
    System.out.println("return");
  }
  
  static String dumpModifiers(int mods) {
    String s = "";
    if (Modifier.isAbstract(mods))
      s += "abstract ";
    if (Modifier.isStatic(mods))
      s += "static ";
    if (Modifier.isPublic(mods))
      s += "public ";
    if (Modifier.isPrivate(mods))
      s += "private ";
    return s;
  }

  static String fullname(Class cls) {
//    String s = "";    
//    Package pkg = cls.getPackage();
//    if (pkg != null)
//      s += pkg.getName() + ".";
//    return s + cls.getName();
    return cls.getName();
  }

  static void printSignature(PrintStream ps, Method m) {
    int mods = m.getModifiers();
    ps.print("  " + dumpModifiers(mods));
    ps.print(fullname(m.getReturnType()) + " ");
    ps.print(m.getName());
    ps.print("(");
    Class[] params = m.getParameterTypes();
    for (int i = 0; i < params.length; i++) {
      ps.print(fullname(params[i]));
      if (i<params.length-1)
        ps.print(", ");
    }
    
    ps.print(")");
    Class[] exceps = m.getExceptionTypes();
    if (exceps.length != 0) {
      ps.print(" throws ");
      for (int i = 0; i < exceps.length; i++)
        ps.print(fullname(exceps[i]));
    }
    ps.println(";");
  }

  static void printSignature(PrintStream ps, Field f) {
    int mods = f.getModifiers();
    ps.print("  " + dumpModifiers(mods));
    ps.print(fullname(f.getType()) + " ");
    ps.print(f.getName());
    ps.println(";");
  }

  static void dumpClassOf(PrintStream ps, Class cls) {
    ps.println("-----------------------------------------------");
    Package pkg = cls.getPackage();
    ps.println("package " + pkg.getName() + ";");

    int mods = cls.getModifiers();
    ps.println(dumpModifiers(mods) + " class " + cls.getName());

    Class scls = cls.getSuperclass();
    Class[] ifaces = cls.getInterfaces();

    ps.println("  extends " + scls.getName());

    if (ifaces.length != 0) {
      ps.print("  implements ");
      for (int i = 0; i < ifaces.length; i++)
        ps.print(ifaces[i].getPackage().getName() + ifaces[i].getName());
    }
    ps.println("{");

    Field[] fields = cls.getDeclaredFields();
    if (fields.length != 0) {
      for (int i = 0; i < fields.length; i++) {
        Field f = fields[i];
        printSignature(ps, f);
      }
    }

    Method[] methods = cls.getDeclaredMethods();
    if (methods.length != 0) {
      for (int i = 0; i < methods.length; i++) {
        Method m = methods[i];
        printSignature(ps, m);
      }
    }
    ps.println("}");
  }


}
