--Name: Nisha Patel
--Description: 1-bit ALU
--File :alu1_vhdl

library ieee;
use ieee.std_logic_1164.all;

entity alu1_tb is
end alu1_tb;

architecture behav of alu1_tb is
  signal a,b,m_anot,m_bnot,cin : std_logic;
  signal s:  std_logic_vector(1 downto 0) := (others => '0');
  signal cout,result:  std_logic;

begin
  alu:entity work.alu1 port map(a=>a, b=>b, m_anot=>m_anot, m_bnot=>m_bnot, cin =>cin,s=> s, cout =>cout, result =>result);
  process
  begin
    --and
    a <='1';
    b <='0';
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "00";    
    wait for 10 ns;

    a <='1';
    b <='1';
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "00";
    wait for 10 ns;

    a <='0';
    b <='1';
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "00";
    wait for 10 ns;

    a <='0';
    b <='0';
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "00";
     wait for 10 ns;
 -- or
    a <='1';
    b <='0';
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "01";
    wait for 10 ns;
    a <='0';
    b <='0';
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "01";
    wait for 10 ns;
    a <='1';
    b <='1';
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "01";
        wait for 10 ns;
    -- add
    a <='1';
    b <='1';
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "10";
    wait for 10 ns;

    a <='1';
    b <='0';
    m_anot <= '0';
    m_bnot <='0';
    cin <='0';
    s <= "10";
     wait for 10 ns;


    
     --nand
    a <='1';
    b <='0';
    m_anot <= '0';
    m_bnot <='1';
    cin <='0';
    s <= "01";
    wait for 10 ns;
    a <='0';
    b <='0';
    m_anot <= '1';
    m_bnot <='1';
    cin <='0';
    s <= "01";
    wait for 10 ns;
    a <='0';
    b <='1';
    m_anot <= '1';
    m_bnot <='0';
    cin <='0';
    s <= "01";
    wait for 10 ns;

    
      -- nor
    a <='0';
    b <='0';
    m_anot <= '1';
    m_bnot <='1';
    cin <='0';
    s <= "00";
    wait for 10 ns;
    a <='0';
    b <='1';
    m_anot <= '1';
    m_bnot <= '0';
    cin <='0';
    s <= "00";
    wait for 10 ns;
    a <='1';
    b <='0';
    m_anot <= '0';
    m_bnot <='1';
    cin <='0';
    s <= "00";
     wait for 10 ns;

    --subtract

    a <='0';
    b <='1';
    m_anot <= '1';
    m_bnot <='0';
    cin <='1';
    s <= "10";
    wait for 10 ns;
    --subtract
    a <='1';
    b <='0';
    m_anot <= '0';
    m_bnot <='1';
    cin <='1';
    s <= "10";
   wait for 10 ns;


    
    
    assert false report "end of test" severity note;
    wait;
  end process;
end behav;
