import java.util.ArrayList;
import java.util.List;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@SuppressWarnings("all")	// this is a sample programm whose goal is to fill the memory
public class HeapFiller {

	public static void main(String[] args) {
		// get a RuntimeMXBean reference
		RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();

		// get the jvm's input arguments as a list of strings
		List<String> listOfArguments = runtimeMxBean.getInputArguments();
		listOfArguments.forEach(arg -> System.out.println("arg: " + arg));

		List dummyCache = new ArrayList<>();
		final int ONE_MEGA_BYTE = 1048576;	// = 1 MB
		int i = 0;
		while (true) {
			i++;
			byte b[] = new byte[ONE_MEGA_BYTE];	
			dummyCache.add(b);
			Runtime rt = Runtime.getRuntime();
			long freeMemInMb = rt.freeMemory() / ONE_MEGA_BYTE;
			System.out.println(i + " free memory: " + freeMemInMb + "MB");
		}
	}
}
