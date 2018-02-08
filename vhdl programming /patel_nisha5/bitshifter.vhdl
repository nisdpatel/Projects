--Name : Nisha Patel
-- Date: 10/21/16
--File : bitshifter.vhdl


library ieee;
use ieee.std_logic_1164.all;

entity bitshifter is
  port ( i: in std_logic_vector (3 downto 0);
       s : in std_logic;
       o : out std_logic_vector (3 downto 0));
end bitshifter;

architecture rtl of bitshifter is
begin
  o(3) <= (not s) and i(2);
  o(2) <= (s and i(3)) or ((not s) and i(1));
  o(1) <= (i(2) and s) or (i(0) and (not s));
  o(0) <= (s and i(1));
 end rtl;
          
