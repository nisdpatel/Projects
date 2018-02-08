library ieee;
use ieee.std_logic_1164.all;

entity alu4_tb is
end alu4_tb;

architecture behav of alu4_tb is
  signal a,b : std_logic_vector(3 downto 0);
  signal m_anot,m_bnot : std_logic;
  signal s: std_logic_vector(1 downto 0);
  signal result: std_logic_vector(3 downto 0);
  signal cin,cout:std_logic;

begin
  alu4:entity work.alu4 port map(a,b,cin,m_anot,m_bnot,s,cout,result);
  process
  begin
    --and
     a <="1111";
    b <="1010";
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "00";
    wait for 10 ns;

    a <="1111";
    b <="1111";
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "00";
    wait for 10 ns;

    a <="0110";
    b <="0110";
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "00";
    wait for 10 ns;

    a <="1010";
    b <="0101";
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "00";
    wait for 10 ns;

    -- or
     a <="1111";
     b <="0000";
     m_anot <= '0';
     m_bnot <='0';
     cin <='0';
     s <= "01";
     wait for 10 ns;
     a <="0101";
     b <="1010";
     m_anot <= '0';
     m_bnot <='0';
     cin <='0';
     s <= "01";
     wait for 10 ns;
     a <="1110";
     b <="1110";
     m_anot <= '0';
     m_bnot <='0';
     cin <='0';
     s <= "01";
     wait for 10 ns;
     
     a <="0011";
     b <="0101";
     m_anot <= '0';
     m_bnot <='0';
     cin <='0';
     s <= "01";
     wait for 10 ns;
     a <="1111";
     b <="0000";
     m_anot <= '0';
     m_bnot <='0';
     cin <='0';
     s <= "01";
     wait for 10 ns;
    
      -- add
     a <="1101";
     b <="1101";
     m_anot <= '0';
     m_bnot <='0';
     cin <='0';
     s <= "10";
     wait for 10 ns;

     a <="1111";
     b <="0000";
     m_anot <= '0';
     m_bnot <='0';
     cin <='0';
     s <= "10";
     wait for 10 ns;
     
     a <="0011";
     b <="1011";
     m_anot <= '0';
     m_bnot <='0';
     cin <='0';
     s <= "10";
     wait for 10 ns;

     a <="0101";
     b <= "1010";
     m_anot <= '0';
     m_bnot <='0';
     cin <='0';
     s <= "10";
     wait for 10 ns;

     a <="0001";
     b <="0011";
     m_anot <= '0';
     m_bnot <='0';
     cin <='0';
     s <= "10";
     wait for 10 ns;

     a <="1100";
     b <="1100";
     m_anot <= '0';
     m_bnot <='0';
     cin <='0';
     s <= "10";
     wait for 10 ns;

      --nand
     a <="1111";
     b <="0000";
     m_anot <= '1';
     m_bnot <='1';
     cin <='0';
     s <= "01";
     wait for 10 ns;
     a <="0000";
     b <="0000";
     m_anot <= '1';
     m_bnot <='1';
     cin <='0';
     s <= "01";
     wait for 10 ns;
     a <="1010";
     b <= "0101";
     m_anot <= '1';
     m_bnot <= '1';
     cin <='0';
     s <= "01";
     wait for 10 ns;
    
     a <="1101";
     b <="0101";
     m_anot <= '1';
     m_bnot <='1';
     cin <='0';
     s <= "01";
     wait for 10 ns;
     a <="0001";
     b <="1000";
     m_anot <= '1';
     m_bnot <='1';
     cin <='0';
     s <= "01";
     wait for 10 ns;
     a <="0010";
     b <= "1110";
     m_anot <= '1';
     m_bnot <= '1';
     cin <='0';
     s <= "01";
     wait for 10 ns;

       -- nor
      a <="0000";
     b <="0000";
     m_anot <= '1';
     m_bnot <='1';
     cin <='0';
     s <= "00";
     wait for 10 ns;
     a <="0000";
     b <="1111";
     m_anot <= '1';
     m_bnot <= '1';
     cin <='0';
     s <= "00";
     wait for 10 ns;
     a <="1010";
     b <="0101";
     m_anot <= '1';
     m_bnot <='1';
     cin <='0';
     s <= "00";
     wait for 10 ns;

     a <="0011";
     b <="0101";
     m_anot <= '1';
     m_bnot <='1';
     cin <='0';
     s <= "00";
     wait for 10 ns;
     a <="1000";
     b <="1001";
     m_anot <= '1';
     m_bnot <= '1';
     cin <='0';
     s <= "00";
     wait for 10 ns;
     a <="0010";
     b <="0101";
     m_anot <= '1';
     m_bnot <='1';
     cin <='0';
     s <= "00";
     wait for 10 ns;

      --subtract
  
     a <="0000";
     b <="1111";
     m_anot <= '0';
     m_bnot <='1';
     cin <='1';
     s <= "10";
     wait for 10 ns;
     a <="1111";
     b <="0000";
     m_anot <= '0';
     m_bnot <='1';
     cin <= '1';
     s <= "10";
     wait for 10 ns;
   
     a <="1101";
     b <="1101";
     m_anot <= '0';
     m_bnot <='1';
     cin <='1';
     s <= "10";
     wait for 10 ns;
    a <="1100";
     b <="0011";
     m_anot <= '0';
     m_bnot <='1';
     cin <='1';
     s <= "10";
     wait for 10 ns;
     a <="1001";
     b <="1101";
     m_anot <= '0';
     m_bnot <='1';
     cin <='1';
     s <= "10";
     wait for 10 ns;
     a <="0001";
     b <="1000";
     m_anot <= '0';
     m_bnot <='1';
     cin <='1';
     s <= "10";
     wait for 10 ns;
     
     assert false report "end of test" severity note;
     wait;
  end process;
end behav;
