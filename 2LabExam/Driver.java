import java.lang.*;

public class Driver
{
    public static void main(String[] args)
    {
	System.out.println(Integer.MAX_VALUE + " is the maximum value of an integer.");
	System.out.println(Integer.MIN_VALUE + " is the minimum value of an integer.\n");

	System.out.println(Double.MAX_VALUE + " is the maximum value of a double.");
	System.out.println(Double.MIN_VALUE + " is the minimum value of a double.\n");

	System.out.println(Float.MAX_VALUE + " is the maximum value of a float.");
	System.out.println(Float.MIN_VALUE + " is the minimum value of a float.\n");

	System.out.println(Long.MAX_VALUE + " is the maximum value of a long.");
	System.out.println(Long.MIN_VALUE + " is the minimum value of a long.\n\n");

	System.out.println("42 in hexadecimal is " + Integer.toHexString(42).toUpperCase() + ".");
	System.out.println("13 in binary is " + Integer.toBinaryString(13) + ".\n\n");

	String superLongText = "I am the very model of a scientist Salarian\nI've studies species turian, asari, and batarian\nI'm quite good at genetics as a subset of biology\nBecause I am an expert which I know is a tautology.\n\nIn four directions cardinal I know the blot routine-ry\nI problem-solve with tools and guns and even farm machinery.\nI'll sing your genome base to base, the T the A the C and G\nI'll solve your ailments be you sick or stroking out or seizure-y\n\nHe'll solve your ailments be you sick or stroking out or seizure-y!\nHe'll solve your ailments be you sick or stroking out or seizure-y!\nHe'll solve your ailments be you sick or stroking out or seizure-seizure-y!\n\nMy knowledge is prodigious though I'm stuffy and professor-y\nI'm fluent in the vorcha tongue and hanar luminescer-y\nMy xenoscience studies range from urban to agrarian\nI am the very model of a scientist Salarian!\n\nHis xenoscience studies range from urban to agrarian\nHe is the very model of a scientist salarian!\n\nWhile you're still eating breakfast I am studying catalysis\nMy ideal date would finish with statistical analysis\nI've mastered optic instruments, reflective and refractory\nI don't begrudge the quarians their hypochondriact-ery\n\nI've memorized – eidetic – all my patients' anamnesises.\nI've written papers, scores and scores, and that's not counting thesises!\nI'll toxify my enemies with nary an apology\nThen spend my weekends brushing up on elcor enzymology!\n\nHe spends his weekends brushing up on elcor enzymology!\nHe spends his weekends brushing up on elcor enzymology!\nHe spends his weekends brushing up on elcor enzymolomology!\n\nWhen I complete a surgery I sign my name in suturing\nI've cut up more batarians than Torfan's famous butchering!\nIf knowledge is a library than I'm its king librarian\nI am the very model of a scientist salarian!\n\nIf knowledge is a library than he's its king librarian\nHe is the very model of a scientist salarian!\n\nWhen I know all the acids be they levo, dextro rotamers,\nWhen I tell your asari child her genes are only sortof yours.\nWhen I read all the theories that my colleagues find heretical\nWhen I know all the finer points of therapies genetical\nWhen I could still cure cancer with my brain just halfway functioning.\nWhen I can fix mutating cells, the point, the nondisjunctioning!\nIn short, when I've a smattering of transgenetic strategy\nYou'll say another scientist has never yet been half of me!\n\nYou'll say another scientist has never yet been half of him!\nYou'll say another scientist has never yet been half of him!\nYou'll say another scientist has never yet been half been half of him!\n\nThough my skeptics call me mad and though they always try to censure me\nAnd even though I'm lucky if I live just half a century\nEven on my offdays I'd outdo the best Noverian\nI am the very model of a scientist salarian!\n\nEven on his offdays he'd outdo the best Noverian\nHe is the very model of a scientist salarian!\n";

	System.out.println("The last index of \"c\" is " + superLongText.lastIndexOf('c') + ".");
	System.out.println("The first index of \"x\" is " + superLongText.indexOf('x') + ".\n\n");

	StringBuilder longText = new StringBuilder(superLongText);

	if(longText.capacity() > superLongText.length())
	    {
		System.out.println("The super long String as a StringBuilder has a higher capacity than the length of the String. The StringBuilder capacity is " + longText.capacity() + " while the String length is " + superLongText.length() + ".\n\n");
	    }
	else if(longText.capacity() < superLongText.length())
	    {
		System.out.println("The super long String as a String has a length larger than the capacity as a StringBuilder. The String length is " + superLongText.length() + " while the StringBuiler capacity is " + longText.capacity() + ".\n\n");
	    }
	else
	    {
		System.out.println("The super long String is the same String length as the StringBuilder capacity. The capacity of the StringBuilder and length of the String are" + longText.capacity() + ".\n\n");
	    }

	System.out.println("The first instance of \"librarian\" is at index " + superLongText.indexOf("librarian") + ".");
	System.out.println("The last instance of \"very model\" is " + superLongText.lastIndexOf("very model") + ".\n\n" );
	System.out.println("The letters from index 519 to index 539 are: " + superLongText.substring(519, 539) + "\n\n");

	char [] myCharArray = superLongText.toCharArray();
	for(int i = superLongText.length() - 1; i >= 0; i--)
	    {
		System.out.print(myCharArray[i]);
	    } 
	System.out.println("");
    }
}
