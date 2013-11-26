public class StringTest {

  private String mInitialString;


  public StringTest(String pInitial) {
    mInitialString = pInitial;
  }


  public void doManipulations() {
    System.out.printf("Ursprünglicher String: %s [objectId=%s]%n", mInitialString, toObjectId(mInitialString));
    System.out.println();

    // neues objekt zuweisen
    mInitialString = new String(mInitialString);
    System.out.println("-- Ursprünglicher String wurde überschrieben --");
    System.out.printf("Ursprünglicher String: %s [objectId=%s]%n", mInitialString, toObjectId(mInitialString));
    System.out.println();

    // uppercase
    String upper = mInitialString.toUpperCase();

    System.out.println("-- Uppercase Test --");
    System.out.printf("Neuer String: %s, [objectId=%s]%n", upper, toObjectId(upper));
    System.out.printf("Ursprünglicher String: %s [objectId=%s]%n", mInitialString, toObjectId(mInitialString));
    System.out.println();

    // substring
    String sub = mInitialString.substring(5);

    System.out.println("-- Substring Test --");
    System.out.printf("Neuer String: %s, [objectId=%s]%n", sub, toObjectId(sub));
    System.out.printf("Ursprünglicher String: %s [objectId=%s]%n", mInitialString, toObjectId(mInitialString));
    System.out.println();

    // string überschreiben
    System.out.println("-- Original überschreiben Test --");
    System.out.printf("Ursprünglicher String: %s [objectId=%s]%n", mInitialString, toObjectId(mInitialString));
    mInitialString = mInitialString.toUpperCase();
    System.out.printf("Ursprünglicher String: %s [objectId=%s]%n", mInitialString, toObjectId(mInitialString));
  }

  public static void main(String... pArgs) {
    String s;
    if ((pArgs != null) && (pArgs.length > 0)) {
      StringBuilder sb = new StringBuilder();
      boolean first = true;
      for(String arg : pArgs) {
        if (!first) {
          sb.append(" ");
        }
        sb.append(arg);
        first = false;
      }
      s = sb.toString();
    } else {
      s = "Some Default String";
    }
    StringTest app = new StringTest(s);
    app.doManipulations();
  }

//               |---------------------| Methoden-Signatur
  private String toObjectId(String pStr) {
    return Integer.toHexString(System.identityHashCode(pStr));
  }

}

