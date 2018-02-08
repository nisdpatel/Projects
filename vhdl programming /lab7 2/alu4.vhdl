library ieee;
use ieee.std_logic_1164.all;

entity alu4 is
  port (a,b :std_logic_vector(3 downto 0);
        m_anot,m_bnot,cin:in std_logic;
        s: in std_logic_vector(1 downto 0);
        cout : out std_logic;
         result : out std_logic_vector(3 downto 0));
end alu4;

architecture behav of alu4 is
  --temporary vatiables
  signal c1,c2,c3: std_logic;
begin
  -- port mapping
  ALU0: entity work.alu1 port map(a(0),b(0),cin,m_anot,m_bnot,s,c1,result(0));
  ALU1: entity work.alu1 port map(a(1),b(1),c1,m_anot,m_bnot,s,c2,result(1));
  ALU2: entity work.alu1 port map(a(2),b(2),c2,m_anot,m_bnot,s,c3,result(2));
  ALU3: entity work.alu1 port map(a(3),b(3),c3,m_anot,m_bnot,s,cout,result(3));
end behav;

        
