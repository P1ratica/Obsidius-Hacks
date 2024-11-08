package obsidiusdevelopment.obsidiusclient.mixin;

import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import obsidiusdevelopment.obsidiusclient.modules.InstantBowKill;

@Mixin(InventoryScreen.class)
public class InventoryScreenMixinBow extends Screen{

    protected InventoryScreenMixinBow(Text title){
        super(title);
    }

    @Inject(method = "init", at = @At("HEAD"))
    public void onInit(CallbackInfo ci){
        if(Modules.get().isActive(InstantBowKill.class)) {
            ButtonWidget toggle = new ButtonWidget.Builder(Text.of("MovePackets: " + (InstantBowKill.shouldAddVelocity0 ? "50" : "OFF")), b -> {
                InstantBowKill.shouldAddVelocity0 = !InstantBowKill.shouldAddVelocity0;
                InstantBowKill.mc.setScreen(new InventoryScreen(InstantBowKill.mc.player));
            })
                    .position(1, 1)
                    .size(90, 12)
                    .build();
            this.addDrawableChild(toggle);
        }
        if(Modules.get().isActive(InstantBowKill.class)) {
        ButtonWidget toggle = new ButtonWidget.Builder(Text.of("MovePackets: " + (InstantBowKill.shouldAddVelocity ? "100" : "OFF")), b -> {
            InstantBowKill.shouldAddVelocity = !InstantBowKill.shouldAddVelocity;
            InstantBowKill.mc.setScreen(new InventoryScreen(InstantBowKill.mc.player));
        })
                .position(1, 13)
                .size(90, 12)
                .build();
        this.addDrawableChild(toggle);
        }
        if(Modules.get().isActive(InstantBowKill.class)) {
            ButtonWidget toggle = new ButtonWidget.Builder(Text.of("MovePackets: " + (InstantBowKill.shouldAddVelocity1 ? "150" : "OFF")), b -> {
                InstantBowKill.shouldAddVelocity1 = !InstantBowKill.shouldAddVelocity1;
                InstantBowKill.mc.setScreen(new InventoryScreen(InstantBowKill.mc.player));
            })
                    .position(1, 25)
                    .size(90, 12)
                    .build();
            this.addDrawableChild(toggle);
        }
        if(Modules.get().isActive(InstantBowKill.class)) {
            ButtonWidget toggle = new ButtonWidget.Builder(Text.of("MovePackets: " + (InstantBowKill.shouldAddVelocity2 ? "200" : "OFF")), b -> {
                InstantBowKill.shouldAddVelocity2 = !InstantBowKill.shouldAddVelocity2;
                InstantBowKill.mc.setScreen(new InventoryScreen(InstantBowKill.mc.player));
            })
                    .position(1, 37)
                    .size(90, 12)
                    .build();
            this.addDrawableChild(toggle);
        }
        if(Modules.get().isActive(InstantBowKill.class)) {
            ButtonWidget toggle = new ButtonWidget.Builder(Text.of("MovePackets: " + (InstantBowKill.shouldAddVelocity3 ? "300" : "OFF")), b -> {
                InstantBowKill.shouldAddVelocity3 = !InstantBowKill.shouldAddVelocity3;
                InstantBowKill.mc.setScreen(new InventoryScreen(InstantBowKill.mc.player));
            })
                    .position(1, 49)
                    .size(90, 12)
                    .build();
            this.addDrawableChild(toggle);
        }
    }
}
