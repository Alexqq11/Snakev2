package testGUI;

import Client.ClientInfo;
import Core.API;
import Entities.*;

import java.awt.*;
import java.util.LinkedList;

public class GamePlayerInterface {


    API api;
    LinkedList<SnakeInfo> snakes;
    LinkedList<BonusInfo> bonuses;
    LinkedList<ClientInfo> clients;
    protected class SnakeField{
        int width; // size must be divised by cell size;
        int height;
        Color backgroundColor;
        Color entityFrameColor;
        int cellSize = 10;
        Graphics g;
        LinkedList<SnakeInfo> snakes;
        LinkedList<BonusInfo> bonuses;
        SnakeField(int width, int height, LinkedList<SnakeInfo> snakes, LinkedList<BonusInfo> bonuses){}
        void drawFiled(){
            g.setColor(backgroundColor);
            g.fillRect(0,0,width, height);
            for (int i = 0; i <= width / cellSize; i++) {
                g.drawLine(i * cellSize, 0, i * cellSize, height);
            }
            for (int i = 0; i <= height / cellSize; i++) {
                g.drawLine(0, i * cellSize, width, i * cellSize);
            }

        }
        public void drawEntity(Graphics g, Point entity, Color color) {
            int width = 10;
            int height = 10;
            g.setColor(entityFrameColor);
            g.fillRect(entity.x * width, entity.y * height, width, height);
            g.setColor(color);
            g.fillRect(entity.x * width + 2, entity.y * height + 2, width - 4, height - 4);// pegment draw with dots;
        }

    }
    private class ClientsStisticArea{
        LinkedList<ClientInfo> client;

        private class ClientLabel{
            int x;
            int y;
            int width;
            int height;
            Rectangle locationArea;
            String clientStatus;
            String snakeStatus;
            String score;
            String plaingTime;


        }

    }

    private class InGameMenu extends UniversalMenu{
        InGameMenu(int parentWidth, int parentHeight, LinkedList<String> buttonsNames, Game.MouseAction mouseAction){
            super(parentWidth,  parentHeight,buttonsNames,mouseAction);
            this.setWidthPersentage(90);
        }
    }

}





    /*


    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            requestFocus();
            return;
        }
        if (api == null){
            return;
        }
        Graphics g = bs.getDrawGraphics();

        if (gameRunned) {
            g.setColor(new Color(20, 100, 10));
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            for (int i = 0; i <= WIDTH / 10; i++) {
                g.drawLine(i * 10, 0, i * 10, HEIGHT);
            }
            for (int i = 0; i <= HEIGHT / 10; i++) {
                g.drawLine(0, i * 10, WIDTH, i * 10);
            }
            if (!gameLose) {
                for (SnakeInfo snake : snakes) {
                    for (Point point : snake.snakePoints) {
                        drawEntity(g, point, Color.cyan);
                    }
                }
                for (BonusInfo bonusInfo : bonuses) {
                    if (bonusInfo.bonusType == BonusType.APPLE)
                        drawEntity(g, new Point(bonusInfo.x, bonusInfo.y), Color.orange);
                    else {
                        drawEntity(g, new Point(bonusInfo.x, bonusInfo.y), Color.gray);
                    }
                }
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.WHITE);
                g.drawString("GAME OVER", 150, 100);
                g.drawString("PRESS UP TO START NEW GAME", 100, 120);
            }
        }else{
            mmainMenu.render(g);
            if (mmainMenu.getButtonState(0)){
                gameRunned = true;
            }
            /*
            mainMenu.render(g);
            if(mainMenu.getNewGameButtonClickedState()){
                gameRunned = true;
            }
            */

/*
        // hero.draw(g, x, y);
        g.dispose();
        bs.show();
                */

   /* }*/


