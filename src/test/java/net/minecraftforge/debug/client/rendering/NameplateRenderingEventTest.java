/*
 * Minecraft Forge
 * Copyright (c) 2016-2021.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.debug.client.rendering;

import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.ChatFormatting;
import net.minecraftforge.client.event.RenderNameplateEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;


@Mod(NameplateRenderingEventTest.MODID)
@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class NameplateRenderingEventTest
{
    public static final String MODID = "nameplate_render_test";
    static final boolean ENABLED = false;

    @SubscribeEvent
    public static void onNameplateRender(RenderNameplateEvent event)
    {

        if(!ENABLED)
        {
            return;
        }

        if(event.getEntity() instanceof Cow)
        {
            event.setContent(new TextComponent("Evil Cow").withStyle(ChatFormatting.RED));
            event.setResult(Event.Result.ALLOW);
        }

        if(event.getEntity() instanceof Player)
        {
            event.setContent(event.getEntity().getDisplayName().copy().withStyle(ChatFormatting.GOLD));
        }
    }
}
