library IEEE;
use ieee.std_logic_1164.all;

entity fulladder is
      -- a,b and cin are the inputs and cout and sum are the outputs
   port (a,b,cin : in std_logic;
  sum,cout :out std_logic);
end fulladder;

architecture rtl of fulladder is
begin
      -- XOR,AND, and OR things tohether
      
     sum <= a xor b xor cin; -- implements sum for the fulladder
 
    cout <= (a and b) or (cin and a) or (cin and b); -- implements carry
      --  the full adder
end rtl;
