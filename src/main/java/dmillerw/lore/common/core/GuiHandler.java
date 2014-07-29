package dmillerw.lore.common.core;

import cpw.mods.fml.common.network.IGuiHandler;
import dmillerw.lore.client.gui.GuiJournal;
import dmillerw.lore.common.network.packet.PacketSyncLore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

/**
 * @author dmillerw
 */
public class GuiHandler implements IGuiHandler {

	public static final int GUI_JOURNAL = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case GUI_JOURNAL:
				PacketSyncLore.updateLore((EntityPlayerMP) player);
				return null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case GUI_JOURNAL: return new GuiJournal(player);
		}
		return null;
	}

}