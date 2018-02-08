library ieee;
use ieee.std_logic_1164.all;

entity mux8 is
  port ( x : in std_logic_vector(7 downto 0);
         sel :in std_logic_vector(2 downto 0);
         r : out std_logic);
end mux8;

architecture behav of mux8 is
begin
  process(x, sel)
  begin
    case sel is
      when "000" => r <= x(0);
      when "001" => r <= x(1);
      when "010" => r <= x(2);
      when "011" => r <= x(3);
      when "100" => r <= x(4);
      when "101" => r <= x(5);
      when "110" => r <= x(6);
      when "111" => r <= x(7);
      when others => NULL;
    end case;
  end process;
end behav;
