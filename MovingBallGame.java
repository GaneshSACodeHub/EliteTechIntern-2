import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingBallGame extends JPanel implements ActionListener {
    private int ballX = 50;   // Initial X position of the ball
    private int ballY = 50;   // Initial Y position of the ball
    private int ballDiameter = 30;  // Diameter of the ball
    private int ballSpeedX = 3; // Horizontal speed
    private int ballSpeedY = 3; // Vertical speed
    private Timer timer;      // Timer for animation

    public MovingBallGame() {
        this.setBackground(Color.BLACK);
        timer = new Timer(10, this); // Refresh every 10ms
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the ball
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update ball's position
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Check for collisions with edges
        if (ballX < 0 || ballX > getWidth() - ballDiameter) {
            ballSpeedX *= -1;  // Reverse horizontal direction
        }
        if (ballY < 0 || ballY > getHeight() - ballDiameter) {
            ballSpeedY *= -1;  // Reverse vertical direction
        }

        // Repaint the panel
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Ball Game");
        MovingBallGame gamePanel = new MovingBallGame();
        frame.add(gamePanel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
