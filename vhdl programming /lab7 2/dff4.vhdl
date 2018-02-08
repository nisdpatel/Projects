library ieee;
use ieee.std_logic_1164.all;

entity dff4 is
  port(d : in std_logic_vector(3 downto 0);
       clock: in std_logic;
       q: out std_logic_vector(3 downto 0));
end dff4;

architecture behav of dff4 is
begin
  DFF0: entity work.dff port map(d(0),clock,q(0));
  DFF1: entity work.dff port map(d(1),clock,q(1));
  DFF2: entity work.dff port map(d(2),clock,q(2));
  DFF3: entity work.dff port map(d(3),clock,q(3));
end behav;
