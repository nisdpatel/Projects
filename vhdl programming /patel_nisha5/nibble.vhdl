--Name : Nisha Patel
-- Date: 10/21/16
--File : nibble.vhdl

library IEEE;
use ieee.std_logic_1164.all;

entity nibble is
  port ( a: in std_logic_vector(3 downto 0);
         b: in std_logic_vector(3 downto 0);
         cin : in std_logic;
         s : out std_logic_vector(3 downto 0);
         cout : out std_logic);
end nibble;

architecture rtl of nibble is

-- temporary variables to hold carry bits

  signal c1,c2,c3: std_logic;

begin
  -- port mapping half and full adders
  HA : entity work.halfadder port map( --(a(0),b(0),s(0),c1);
    a => a(0),
    b => b(0),
    sum => s(0),
    cout => c1);
  
  FA1 : entity work.fulladder port map( -- ( a(1),b(1),cin, s(1),c2);
    a => a(1),
    b => b(1),
    cin => c1,
    sum => s(1),
    cout => c2 );
  FA2: entity work.fulladder port map( -- (a(2), b(2),c2,s(2),c3);
    a => a(2),
    b => b(2),
    cin => c2,
    sum => s(2),
    cout => c3);


  FA3 : entity work.fulladder port map ( --(a(3),b(3),c3,s(3),cout);
    a => a(3),
    b => b(3),
    cin => c3,
    sum => s(3),
    cout => cout);

end rtl;
