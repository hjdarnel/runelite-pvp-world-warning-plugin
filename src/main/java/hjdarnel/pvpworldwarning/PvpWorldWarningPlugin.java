package hjdarnel.pvpworldwarning;

import javax.inject.Inject;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "PvP World Warning",
	description = "Display an overlay when you're in a PvP world (accidentally)",
	tags = {"overlay", "pvp", "world"}
)

public class PvpWorldWarningPlugin extends Plugin
{
	@Inject
	private PvpWorldWarningOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Override
	public void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	public void shutDown()
	{
		overlayManager.remove(overlay);
	}
}