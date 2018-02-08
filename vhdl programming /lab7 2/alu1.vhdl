--Name: Nisha Patel
----Description: entity for 1-bit ALU
------File :alu1.vhdl 

library ieee;
use ieee.std_logic_1164.all;

entity alu1 is
  port (a,b,cin: in std_logic;
       m_anot,m_bnot : in std_logic;
        s : in std_logic_vector(1 downto 0);
        cout,result : out std_logic);
end alu1;

architecture rtl of alu1 is
  signal  anot,bnot :std_logic;
  signal minput:  std_logic_vector(3 downto 0) := (others => '0');
begin
  anot <=a;
  bnot <=b;
  process (a,b,m_anot,m_bnot,cin,s)
--  anot <= a;
  --bnot <=b;
  begin
  if(a = '1')then
    anot <= not a;
    end if; 
    if (b = '1')then
      bnot <= not b;
    end if;
  end process;
    minput(0) <= (a and b);
    minput(1) <= (a or b);
    minput(3) <= '0';
  

   FA: entity work.fulladder port map(a=>a,b=>b,cin=>cin,sum=>minput(2),cout=>cout);
 -- minput(3) <= '0';
  MUX: entity work.mux port map(minput,s,result);


 
                                  

  end rtl;
