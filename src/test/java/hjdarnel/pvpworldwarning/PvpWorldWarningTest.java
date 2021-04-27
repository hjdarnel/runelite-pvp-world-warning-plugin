package hjdarnel.pvpworldwarning;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class PvpWorldWarningTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(PvpWorldWarningPlugin.class);
		RuneLite.main(args);
	}
}