package hjdarnel.pvpworldwarning;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.TitleComponent;


class PvpWorldWarningOverlay extends OverlayPanel
{
	@Inject
	private Client client;

	@Inject
	private PvpWorldWarningOverlay()
	{
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
		panelComponent.setPreferredSize(new Dimension(150, 0));
	}

	@Override
	public Dimension render(Graphics2D graphics) {
		if (client.getWorldType().contains(WorldType.PVP))
		{
			final String text = "You are in a PvP world!";
			final int textWidth = graphics.getFontMetrics().stringWidth(text);
			final int textHeight = graphics.getFontMetrics().getAscent() - graphics.getFontMetrics().getDescent();
			final int width = (int) client.getRealDimensions().getWidth();
			java.awt.Point jPoint = new java.awt.Point((width / 2) - textWidth, textHeight + 150);

			panelComponent.getChildren().clear();
			panelComponent.getChildren().add(TitleComponent.builder().text(text).color(Color.RED).build());
			panelComponent.setPreferredLocation(jPoint);
			return panelComponent.render(graphics);
		}

		return null;
	}
}