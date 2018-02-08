library ieee;
use ieee.std_logic_1164.all;

entity dff is
  port (d,clock : in std_logic;
        q: out std_logic);

end dff;
architecture behav of dff is
begin
  process
  begin
    -- falling edge triggered
    wait until clock'event and clock = '0';
    q <= d; -- set q equals d
  end process;
 
end behav;


-- I tried using the lengthy approach by making srlatch then combined with
-- dlatch and then merge two dlatches together but it was so confusing that I
-- was unable to merge them.For some reason the value of final q was undefined.
-- So I chose the above approch: 
-- When the clock and clock even are 0 then only the falling edge triggered and
-- set q equals to d. When the execution reaches the wait, it stops until the
-- condition is true. 
