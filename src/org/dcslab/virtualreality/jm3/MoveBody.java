/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dcslab.virtualreality.jm3;

import com.jme3.animation.AnimControl;
import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.debug.SkeletonDebugger;
import org.dcslab.virtualreality.controller.BridgeController;
import org.dcslab.virtualreality.controller.SensorCallback;
import org.dcslab.virtualreality.model.Percept;

/**
 *
 * @author emmanuelsantana
 */
public class MoveBody extends SimpleApplication implements SensorCallback {

    private AnimControl control;
    private Node player;
    private BridgeController bridgeController;
    private BitmapText menuText;
    private BitmapText controllerStatusText;
    private String playerModelPath;
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
            if (name.equals("Rotate") && !keyPressed) {
                //moveUpperArmRight(Float.valueOf(0), Float.valueOf(0), Float.valueOf(45));
            } else if (name.equals("Subscribe") && !keyPressed) {
                subscribe();
            } else if (name.equals("Unsubscribe") && !keyPressed) {
                unsubscribe();
            } else if (name.equals("First_Person") && !keyPressed) {
                setCamPosition(CamPosition.FIRST_PERSON);
            } else if (name.equals("Third_Person") && !keyPressed) {
                setCamPosition(CamPosition.THIRD_PERSON);
            }
        }
    };


    @Override
    public void simpleInitApp() {
        showMenu();
        showControllerStatus("No Connected", ColorRGBA.Red);
        setUpGame();
        initKeys();
        addLights();
        addPlayerModel();
        initSkeletonDebugger();
        initKeys();
    }

    @Override
    public void simpleUpdate(float tpf) {
    }

    public void subscribe() {
        bridgeController.addObserver(this);
        showControllerStatus("Connected", ColorRGBA.Green);
    }

    public void unsubscribe() {
        bridgeController.deleteObserver(this);
        showControllerStatus("No Connected", ColorRGBA.Red);
    }

    /**
     * Custom Keybinding: Map named actions to inputs.
     */
    private void initKeys() {
        inputManager.addMapping("Rotate", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addMapping("Subscribe", new KeyTrigger(KeyInput.KEY_1));
        inputManager.addMapping("Unsubscribe", new KeyTrigger(KeyInput.KEY_2));
        inputManager.addMapping("First_Person", new KeyTrigger(KeyInput.KEY_3));
        inputManager.addMapping("Third_Person", new KeyTrigger(KeyInput.KEY_4));
        inputManager.addListener(actionListener, "Rotate", "Subscribe", "Unsubscribe", "First_Person", "Third_Person");
    }

    private void showMenu() {
        menuText = new BitmapText(guiFont, false);
        menuText.setSize(guiFont.getCharSet().getRenderedSize());      // font size
        menuText.setColor(ColorRGBA.Black);                             // font color
        menuText.setText("1 - Connect to controller\n"
                + "2 - Disconect from controller\n"
                + "3 - First-person view\n"
                + "4 - Third-person view\n");             // the text
        menuText.setLocalTranslation(10, 100, 0); // position
        guiNode.attachChild(menuText);
    }

    private void showControllerStatus(String message, ColorRGBA color) {
        if (controllerStatusText != null) {
            guiNode.detachChild(controllerStatusText);
        }
        controllerStatusText = new BitmapText(guiFont, false);
        controllerStatusText.setSize(guiFont.getCharSet().getRenderedSize());      // font size
        controllerStatusText.setColor(color);                             // font color
        controllerStatusText.setText(message);             // the text
        controllerStatusText.setLocalTranslation(10, controllerStatusText.getLineHeight(), 0);
        guiNode.attachChild(controllerStatusText);
    }

    private void setUpGame() {
        setDisplayStatView(false);
        setDisplayFps(false);
        setPauseOnLostFocus(false);
        flyCam.setEnabled(false);
        flyCam.setMoveSpeed(15f);
        viewPort.setBackgroundColor(ColorRGBA.LightGray);
    }

    private void addLights() {
        DirectionalLight dl = new DirectionalLight();
        dl.setDirection(new Vector3f(-0.5f, -5f, -1).normalizeLocal());
        rootNode.addLight(dl);

        /**
         * A white ambient light source.
         */
        AmbientLight ambient = new AmbientLight();
        ambient.setColor(ColorRGBA.White);
        rootNode.addLight(ambient);
    }

    private void addPlayerModel() {
        player = (Node) assetManager.loadModel(playerModelPath);
        //player = (Node) assetManager.loadModel("Models/Body/Cube.002.mesh.xml");
        player.setLocalScale(0.2f);
        rootNode.attachChild(player);
        control = player.getControl(AnimControl.class);
    }

    private void initSkeletonDebugger() {
        SkeletonDebugger skeletonDebug = new SkeletonDebugger("skeleton", control.getSkeleton());
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Green);
        mat.getAdditionalRenderState().setDepthTest(false);
        skeletonDebug.setMaterial(mat);
        player.attachChild(skeletonDebug);
    }

    private void setCamPosition(CamPosition camPosition) {
        switch (camPosition) {
            case FIRST_PERSON:
                cam.setLocation(new Vector3f(-0.14754543f, 42.864216f, -41.089787f));
                cam.setRotation(new Quaternion(0.22504462f, -0.02235216f, 0.005164684f, 0.97407836f));
                break;
            case THIRD_PERSON:
                cam.setLocation(new Vector3f(0.23479334f, 7.4654465f, -5.423682f));
                cam.setRotation(new Quaternion(0.36344275f, -0.004443036f, 0.0017334116f, 0.9316043f));
                break;
        }
    }

    private void applyPercept3D(Percept percept) {
         
        System.out.println("Angle: " + percept.getAngle() + " Distance: " + percept.getDistance());
    }

    @Override
    public void update(Percept percept) {
        applyPercept3D(percept);
    }

    private enum CamPosition {
        FIRST_PERSON,
        THIRD_PERSON
    }
}
