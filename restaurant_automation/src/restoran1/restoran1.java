package restoran1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

	
	
	
	
	
	
	

	
	

	

public class restoran1 extends JFrame {

    // ... (existing code)

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3307/restoran";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // ... (existing code)

    private static void kaydet(boolean corba, boolean tavuk, boolean kebap, boolean pizza,
                               boolean hamburger, boolean tralice, boolean sutlac, boolean brovni,
                               boolean ekler, boolean asure, boolean ayran, boolean msuyu,
                               boolean soda, boolean kahve) {

        try {
            // MySQL veritabanına bağlanma
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // SQL sorgusu
            String sql = "INSERT INTO siparis_kaydi (kullaniciAdi, siparisi) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Parametreleri set et
                preparedStatement.setString(1, "kullaniciAdi"); // Burada kullanıcı adını nasıl alacağınızı belirtmelisiniz
                preparedStatement.setString(2, buildSiparisString(corba, tavuk, kebap, pizza, hamburger,
                        tralice, sutlac, brovni, ekler, asure, ayran, msuyu, soda, kahve));

                // Sorguyu çalıştır
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Sipariş başarıyla kaydedildi.");
            }

            // Bağlantıyı kapat
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static String buildSiparisString(boolean corba, boolean tavuk, boolean kebap, boolean pizza,
                                             boolean hamburger, boolean tralice, boolean sutlac, boolean brovni,
                                             boolean ekler, boolean asure, boolean ayran, boolean msuyu,
                                             boolean soda, boolean kahve) {
        StringBuilder siparisBuilder = new StringBuilder();

        if (corba) siparisBuilder.append("Çorba ");
        if (tavuk) siparisBuilder.append("Tavuk ");
        if (kebap) siparisBuilder.append("Kebap ");
        if (pizza) siparisBuilder.append("Pizza ");
        if (hamburger) siparisBuilder.append("Hamburger ");
        if (tralice) siparisBuilder.append("Tralice ");
        if (sutlac) siparisBuilder.append("Sutlac ");
        if (brovni) siparisBuilder.append("Brovni ");
        if (ekler) siparisBuilder.append("Ekler ");
        if (asure) siparisBuilder.append("Asure ");
        if (ayran) siparisBuilder.append("Ayran ");
        if (msuyu) siparisBuilder.append("Meyve Suyu ");
        if (soda) siparisBuilder.append("Soda ");
        if (kahve) siparisBuilder.append("Kahve ");

        return siparisBuilder.toString().trim();
    

}

    // ... (existing code)
}

    

		
















		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					restoran1 frame = new restoran1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public restoran1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 697);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(192, 192, 192));
		contentPane_1.setBounds(-168, -70, 1152, 720);
		contentPane.add(contentPane_1);
		contentPane_1.setLayout(null);
		
		JCheckBox corbaCheckbox = new JCheckBox("Çorba-20TL");
		corbaCheckbox.setBounds(177, 219, 135, 32);
		corbaCheckbox.setForeground(new Color(64, 0, 64));
		corbaCheckbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		corbaCheckbox.setBackground(new Color(248, 243, 194));
		contentPane_1.add(corbaCheckbox);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(268, 257, 44, 32);
		contentPane_1.add(spinner);
		
		JLabel lblNewLabel = new JLabel("Adet:");
		lblNewLabel.setBackground(new Color(248, 243, 194));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(177, 256, 68, 28);
		contentPane_1.add(lblNewLabel);
		

		
		JCheckBox tavukCheckbox = new JCheckBox("Tavuk Şiş-80TL");
		tavukCheckbox.setForeground(new Color(64, 0, 64));
		tavukCheckbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		tavukCheckbox.setBackground(new Color(248, 243, 194));
		tavukCheckbox.setBounds(339, 219, 135, 32);
		contentPane_1.add(tavukCheckbox);
			
		
		JLabel lblNewLabel_3 = new JLabel("Adet:");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBackground(new Color(248, 243, 194));
		lblNewLabel_3.setBounds(352, 256, 68, 28);
		contentPane_1.add(lblNewLabel_3);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(430, 257, 44, 32);
		contentPane_1.add(spinner_1);
		
		JCheckBox kebapCheckbox = new JCheckBox("Kebap-90TL");
		kebapCheckbox.setForeground(new Color(64, 0, 64));
		kebapCheckbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		kebapCheckbox.setBackground(new Color(248, 243, 194));
		kebapCheckbox.setBounds(503, 219, 135, 32);
		contentPane_1.add(kebapCheckbox);
		
		JCheckBox pizzaCheckbox = new JCheckBox("Pizza-70TL");
		pizzaCheckbox.setForeground(new Color(64, 0, 64));
		pizzaCheckbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		pizzaCheckbox.setBackground(new Color(248, 243, 194));
		pizzaCheckbox.setBounds(661, 219, 135, 32);
		contentPane_1.add(pizzaCheckbox);
		
		JCheckBox hamburgerCheckbox = new JCheckBox("Burger-65TL");
		hamburgerCheckbox.setForeground(new Color(64, 0, 64));
		hamburgerCheckbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		hamburgerCheckbox.setBackground(new Color(248, 243, 194));
		hamburgerCheckbox.setBounds(823, 219, 135, 32);
		contentPane_1.add(hamburgerCheckbox);
		
		JCheckBox traliceCheckbox = new JCheckBox("Traliçe-45TL");
		traliceCheckbox.setForeground(new Color(64, 0, 64));
		traliceCheckbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		traliceCheckbox.setBackground(new Color(248, 243, 194));
		traliceCheckbox.setBounds(177, 430, 135, 32);
		contentPane_1.add(traliceCheckbox);
		
		JCheckBox sutlacChecbox = new JCheckBox("Sütlaç-40TL");
		sutlacChecbox.setForeground(new Color(64, 0, 64));
		sutlacChecbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		sutlacChecbox.setBackground(new Color(248, 243, 194));
		sutlacChecbox.setBounds(339, 430, 135, 32);
		contentPane_1.add(sutlacChecbox);
		
		JCheckBox brovniCheckbox = new JCheckBox("Brovni-45TL");
		brovniCheckbox.setForeground(new Color(64, 0, 64));
		brovniCheckbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		brovniCheckbox.setBackground(new Color(248, 243, 194));
		brovniCheckbox.setBounds(503, 430, 135, 32);
		contentPane_1.add(brovniCheckbox);
		
		JCheckBox eklerChecbox = new JCheckBox("Ekler-20TL");
		eklerChecbox.setForeground(new Color(64, 0, 64));
		eklerChecbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		eklerChecbox.setBackground(new Color(248, 243, 194));
		eklerChecbox.setBounds(661, 430, 135, 32);
		contentPane_1.add(eklerChecbox);
		
		JCheckBox asureChecbox = new JCheckBox("Aşure-40TL");
		asureChecbox.setForeground(new Color(64, 0, 64));
		asureChecbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		asureChecbox.setBackground(new Color(248, 243, 194));
		asureChecbox.setBounds(823, 430, 135, 32);
		contentPane_1.add(asureChecbox);
		
		JCheckBox ayranCheckbox = new JCheckBox("Ayran-5TL");
		ayranCheckbox.setForeground(new Color(64, 0, 64));
		ayranCheckbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		ayranCheckbox.setBackground(new Color(248, 243, 194));
		ayranCheckbox.setBounds(177, 639, 135, 32);
		contentPane_1.add(ayranCheckbox);
		
		JCheckBox msuyuCheckbox = new JCheckBox("M.suyu-15TL");
		msuyuCheckbox.setForeground(new Color(64, 0, 64));
		msuyuCheckbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		msuyuCheckbox.setBackground(new Color(248, 243, 194));
		msuyuCheckbox.setBounds(339, 639, 135, 32);
		contentPane_1.add(msuyuCheckbox);
		
		JCheckBox sodaCheckbox = new JCheckBox("Soda-10TL");
		sodaCheckbox.setForeground(new Color(64, 0, 64));
		sodaCheckbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		sodaCheckbox.setBackground(new Color(248, 243, 194));
		sodaCheckbox.setBounds(503, 639, 135, 32);
		contentPane_1.add(sodaCheckbox);
		
		JCheckBox kahveCheckbox = new JCheckBox("Kahve-20TL");
		kahveCheckbox.setForeground(new Color(64, 0, 64));
		kahveCheckbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		kahveCheckbox.setBackground(new Color(248, 243, 194));
		kahveCheckbox.setBounds(661, 639, 135, 32);
		contentPane_1.add(kahveCheckbox);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\çorba.png"));
		lblNewLabel_1.setBounds(177, 84, 135, 129);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Adet:");
		lblNewLabel_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBackground(new Color(248, 243, 194));
		lblNewLabel_3_1.setBounds(503, 256, 68, 28);
		contentPane_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Adet:");
		lblNewLabel_3_2.setForeground(Color.BLACK);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBackground(new Color(248, 243, 194));
		lblNewLabel_3_2.setBounds(661, 256, 68, 28);
		contentPane_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Adet:");
		lblNewLabel_3_3.setForeground(Color.BLACK);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3.setBackground(new Color(248, 243, 194));
		lblNewLabel_3_3.setBounds(823, 261, 68, 28);
		contentPane_1.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Adet:");
		lblNewLabel_3_4.setForeground(Color.BLACK);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_4.setBackground(new Color(248, 243, 194));
		lblNewLabel_3_4.setBounds(177, 468, 68, 28);
		contentPane_1.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Adet:");
		lblNewLabel_3_5.setForeground(Color.BLACK);
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_5.setBackground(new Color(248, 243, 194));
		lblNewLabel_3_5.setBounds(349, 468, 68, 28);
		contentPane_1.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("Adet:");
		lblNewLabel_3_6.setForeground(Color.BLACK);
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_6.setBackground(new Color(248, 243, 194));
		lblNewLabel_3_6.setBounds(503, 468, 68, 28);
		contentPane_1.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("Adet:");
		lblNewLabel_3_7.setForeground(Color.BLACK);
		lblNewLabel_3_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_7.setBackground(new Color(248, 243, 194));
		lblNewLabel_3_7.setBounds(661, 468, 68, 28);
		contentPane_1.add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_3_8 = new JLabel("Adet:");
		lblNewLabel_3_8.setForeground(Color.BLACK);
		lblNewLabel_3_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_8.setBackground(new Color(248, 243, 194));
		lblNewLabel_3_8.setBounds(823, 468, 68, 28);
		contentPane_1.add(lblNewLabel_3_8);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setBounds(594, 257, 44, 32);
		contentPane_1.add(spinner_1_1);
		
		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setBounds(752, 257, 44, 32);
		contentPane_1.add(spinner_1_2);
		
		JSpinner spinner_1_3 = new JSpinner();
		spinner_1_3.setBounds(914, 257, 44, 32);
		contentPane_1.add(spinner_1_3);
		
		JSpinner spinner_1_4 = new JSpinner();
		spinner_1_4.setBounds(268, 469, 44, 32);
		contentPane_1.add(spinner_1_4);
		
		JSpinner spinner_1_5 = new JSpinner();
		spinner_1_5.setBounds(430, 469, 44, 32);
		contentPane_1.add(spinner_1_5);
		
		JSpinner spinner_1_6 = new JSpinner();
		spinner_1_6.setBounds(594, 469, 44, 32);
		contentPane_1.add(spinner_1_6);
		
		JSpinner spinner_1_7 = new JSpinner();
		spinner_1_7.setBounds(752, 469, 44, 32);
		contentPane_1.add(spinner_1_7);
		
		JSpinner spinner_1_8 = new JSpinner();
		spinner_1_8.setBounds(914, 469, 44, 32);
		contentPane_1.add(spinner_1_8);
		
		JSpinner spinner_1_9 = new JSpinner();
		spinner_1_9.setBounds(268, 678, 44, 32);
		contentPane_1.add(spinner_1_9);
		
		JSpinner spinner_1_10 = new JSpinner();
		spinner_1_10.setBounds(430, 678, 44, 32);
		contentPane_1.add(spinner_1_10);
		
		JSpinner spinner_1_10_1 = new JSpinner();
		spinner_1_10_1.setBounds(594, 678, 44, 32);
		contentPane_1.add(spinner_1_10_1);
		
		JSpinner spinner_1_10_2 = new JSpinner();
		spinner_1_10_2.setBounds(752, 678, 44, 32);
		contentPane_1.add(spinner_1_10_2);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Adet:");
		lblNewLabel_3_4_1.setForeground(Color.BLACK);
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_4_1.setBackground(new Color(248, 243, 194));
		lblNewLabel_3_4_1.setBounds(177, 677, 68, 28);
		contentPane_1.add(lblNewLabel_3_4_1);
		
		JLabel lblNewLabel_3_4_2 = new JLabel("Adet:");
		lblNewLabel_3_4_2.setForeground(Color.BLACK);
		lblNewLabel_3_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_4_2.setBackground(new Color(248, 243, 194));
		lblNewLabel_3_4_2.setBounds(339, 677, 68, 28);
		contentPane_1.add(lblNewLabel_3_4_2);
		
		JLabel lblNewLabel_3_4_3 = new JLabel("Adet:");
		lblNewLabel_3_4_3.setForeground(Color.BLACK);
		lblNewLabel_3_4_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_4_3.setBackground(new Color(248, 243, 194));
		lblNewLabel_3_4_3.setBounds(503, 677, 68, 28);
		contentPane_1.add(lblNewLabel_3_4_3);
		
		JLabel lblNewLabel_3_4_4 = new JLabel("Adet:");
		lblNewLabel_3_4_4.setForeground(Color.BLACK);
		lblNewLabel_3_4_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_4_4.setBackground(new Color(248, 243, 194));
		lblNewLabel_3_4_4.setBounds(661, 677, 68, 28);
		contentPane_1.add(lblNewLabel_3_4_4);
		
		JButton siparisButton = new JButton("Siparişi \r\nTamamla");
		siparisButton.setForeground(new Color(0, 0, 0));
		siparisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 StringBuilder message = new StringBuilder("Seçilen Ürünler:\n Afiyet Olsun :) \n");

	                if ((corbaCheckbox.isSelected())) {
	                    message.append("Çorba\n");
	                }
	                if ((tavukCheckbox.isSelected())) {
	                    message.append("Tavuk\n");
	                }     
	                if ((kebapCheckbox.isSelected())) {
	                    message.append("Kebap\n");
	                }
	                if ((pizzaCheckbox.isSelected())) {
	                    message.append("Pizza\n");
	                }
	                if ((hamburgerCheckbox.isSelected())) {
	                    message.append("Burger\n");
	                }
	                if ((traliceCheckbox.isSelected())) {
	                    message.append("Traliçe\n");
	                }
	                if ((sutlacChecbox.isSelected())) {
	                    message.append("Sütlaç\n");
	                }
					if ((brovniCheckbox.isSelected())) {
	                    message.append("Brovni\n");
	                }
					if ((eklerChecbox.isSelected())) {
	                    message.append("Ekler\n");
	                }
					if ((asureChecbox.isSelected())) {
	                    message.append("Aşure\n");
	                }      
	                if (ayranCheckbox.isSelected()) {
	                message.append("Ayran\n");
	                }
	                if (msuyuCheckbox.isSelected()) {
		                message.append("Meyve Suyu\n");
		            }                
	                if (sodaCheckbox.isSelected()) {
		                message.append("Soda\n");
		            } 
	                if (kahveCheckbox.isSelected()) {
		                message.append("Su\n");
		            }

	                Component contentPane = null;
					JOptionPane.showMessageDialog(contentPane, message.toString(), "Seçilen Ürünler", JOptionPane.INFORMATION_MESSAGE);

	}
	});

				
			
		
		siparisButton.setBackground(new Color(244, 245, 214));
		siparisButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		siparisButton.setBounds(823, 557, 164, 83);
		contentPane_1.add(siparisButton);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\tavuk.png"));
		lblNewLabel_4.setBounds(339, 84, 135, 129);
		contentPane_1.add(lblNewLabel_4);
		
		
		
		JLabel lblNewLabel_4_1 = new JLabel("New label");
		lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\kebap.png"));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(503, 84, 135, 129);
		contentPane_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("New label");
		lblNewLabel_4_2.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\pizza.png"));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setBounds(661, 84, 135, 129);
		contentPane_1.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("New label");
		lblNewLabel_4_3.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\burger.png"));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setBounds(823, 84, 135, 129);
		contentPane_1.add(lblNewLabel_4_3);
		
		

		
		
		JLabel lblNewLabel_4_3_1 = new JLabel("New label");
		lblNewLabel_4_3_1.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\tralice.png"));
		lblNewLabel_4_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3_1.setBounds(177, 295, 135, 129);
		contentPane_1.add(lblNewLabel_4_3_1);
		
		JLabel lblNewLabel_4_3_3 = new JLabel("New label");
		lblNewLabel_4_3_3.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\brovni.png"));
		lblNewLabel_4_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3_3.setBounds(503, 295, 135, 129);
		contentPane_1.add(lblNewLabel_4_3_3);
		
		JLabel lblNewLabel_4_3_4 = new JLabel("New label");
		lblNewLabel_4_3_4.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\ekler.png"));
		lblNewLabel_4_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3_4.setBounds(661, 294, 135, 129);
		contentPane_1.add(lblNewLabel_4_3_4);
		
		JLabel lblNewLabel_4_3_5 = new JLabel("New label");
		lblNewLabel_4_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3_5.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\aşure.png"));
		lblNewLabel_4_3_5.setBounds(823, 295, 135, 129);
		contentPane_1.add(lblNewLabel_4_3_5);
		
		JLabel lblNewLabel_4_3_6 = new JLabel("New label");
		lblNewLabel_4_3_6.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\ayran.png"));
		lblNewLabel_4_3_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3_6.setBounds(177, 506, 135, 129);
		contentPane_1.add(lblNewLabel_4_3_6);
		
		JLabel lblNewLabel_4_3_7 = new JLabel("New label");
		lblNewLabel_4_3_7.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\meyve.png"));
		lblNewLabel_4_3_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3_7.setBounds(339, 504, 135, 129);
		contentPane_1.add(lblNewLabel_4_3_7);
		
		JLabel lblNewLabel_4_3_8 = new JLabel("New label");
		lblNewLabel_4_3_8.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\soda.png"));
		lblNewLabel_4_3_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3_8.setBounds(503, 504, 135, 129);
		contentPane_1.add(lblNewLabel_4_3_8);
		
		JLabel lblNewLabel_4_3_9 = new JLabel("New label");
		lblNewLabel_4_3_9.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\kahve.png"));
		lblNewLabel_4_3_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3_9.setBounds(661, 506, 135, 129);
		contentPane_1.add(lblNewLabel_4_3_9);
		
		
		
		JLabel lblNewLabel_4_3_3_1 = new JLabel("New label");
		lblNewLabel_4_3_3_1.setIcon(new ImageIcon("C:\\Users\\hatice\\Desktop\\projeler\\java\\restoran1\\img\\sut.png"));
		lblNewLabel_4_3_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3_3_1.setBounds(339, 294, 135, 129);
		contentPane_1.add(lblNewLabel_4_3_3_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(165, 72, 998, 648);
		contentPane_1.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hatice\\Downloads\\Untitled design.png"));
	}
}
