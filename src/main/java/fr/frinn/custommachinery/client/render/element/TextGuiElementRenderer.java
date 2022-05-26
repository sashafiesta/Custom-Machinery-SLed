package fr.frinn.custommachinery.client.render.element;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.frinn.custommachinery.api.guielement.IGuiElementRenderer;
import fr.frinn.custommachinery.api.guielement.IMachineScreen;
import fr.frinn.custommachinery.common.data.gui.TextGuiElement;
import net.minecraft.client.Minecraft;

public class TextGuiElementRenderer implements IGuiElementRenderer<TextGuiElement> {

    @Override
    public void renderElement(PoseStack matrix, TextGuiElement element, IMachineScreen screen) {
        int posX = switch (element.getAlignment()) {
            case CENTER -> element.getX() - Minecraft.getInstance().font.width(element.getText().getString()) / 2;
            case RIGHT -> element.getX() - Minecraft.getInstance().font.width(element.getText().getString());
            default -> element.getX();
        };
        int posY = element.getY();
        Minecraft.getInstance().font.draw(matrix, element.getText(), posX, posY, element.getColor());
    }

    @Override
    public void renderTooltip(PoseStack matrix, TextGuiElement element, IMachineScreen screen, int mouseX, int mouseY) {

    }

    @Override
    public boolean isHovered(TextGuiElement element, IMachineScreen screen, int mouseX, int mouseY) {
        return false;
    }
}
