--Name : Nisha Patel
-- Date: 10/21/16
--File : halfadder.vhdl


library IEEE;
use ieee.std_logic_1164.all;

entity halfadder is
  -- a and b are the inputs and carry and sum are the output
  port(a,b : in std_logic;
       sum,carry : out std_logic);
end halfadder;

architecture rtl of halfadder is
begin
  -- XOR and AND all things together
  sum <= a xor b; -- implements sum for half adder
  carry <= a and b; -- implements carry for half adder
end rtl;

  
