--Name : Nisha Patel
-- Date: 10/21/16
--File : experiment1.vhdl

library IEEE;
use IEEE.std_logic_1164.all;

entity experiment1 is
  -- i is the input and o is the output
  port(i : in std_logic_vector(2 downto 0);
       o : out std_logic_vector(7 downto 0));
end experiment1;

 architecture rtl of experiment1 is
  begin
     -- not and and all things together
   o(0) <= (not i(2)) and (not i(1)) and (not i(0));
   o(1) <= (not i(2)) and (not i(1)) and i(0);
   o(2) <= (not i(2)) and i(1) and (not i(0));
   o(3) <= (not i(2)) and i(1) and i(0);
   o(4) <= i(2) and (not i(1)) and (not i(0));
   o(5) <= i(2) and (not i(1)) and i(0);
   o(6) <= i(2) and i(1) and (not i(0));
   o(7) <= i(2) and i(1) and i(0);
 end rtl;
 


 -- cite
 -- :http://vhdlguru.blogspot.com/2010/03/3-8-decoder-using-basic-logic-gates.html 
