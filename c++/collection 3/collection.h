/*
 * File: collection.h
 * Authors: Cody Robertson and Nisha Patel
 * Date: 10-29-15
 * Description: The definition of the Collection class.
 */

#ifndef COLLECTION_H
#define COLLECTION_H

#include <list>
#include "cd.h"

class Collection {
 private:
  std::list<cd> cd_collection;
 public:
  Collection();
  /*
   * Description:
   *   Default constructor.
   */

  ~Collection();
  /*
   * Description:
   *   Default destructor.
   *
   * Post-conditions:
   *   Each cd is individually deallocated.
   */

  void insert_sorted(cd newCD);
  /*
   * Description:
   *   Inserts a new cd object into the list, sorted by the artist's name.
   *
   * Post-conditions:
   *   The list is still sorted by artist name and a new CD is added to the list.
   */

  void read_from_file(std::string filename);
  /*
   * Description:
   *   Reads data from file in formatted manner to populate list of cd structs.
   *
   * Pre-condtions:
   *   Filename should be a valid text file in the correct format.
   *
   * Post-conditions:
   *   Data should be read in and added to the list.
   */

  void write_to_file(std::string filename);
  /*
   * Description:
   *   Writes data from list to file in formatted manner.
   *
   * Post-conditions:
   *   All data from the list has been written to filename.
   */

  void print();
  /*
   * Description:
   *   Prints all CD's in the collection to the user.
   *
   * Post-conditions:
   *   All data in all CD's is printed to the user.
   */

  void find_artist(std::string artistToFind);
  /*
   * Description:
   *   Prints all of the albums by artistToFind.
   *
   * Post-conditions:
   *   All album names by artistToFind are printed to the user, if they exist.
   */

  void find_album(std::string albumToFind);
  /*
   * Description:
   *   Prints the artist of the album albumToFind.
   *
   * Post-conditions:
   *   The artist name of albumToFind is printed to the user, if it exists.
   */

  void remove(std::string artistToDelete, std::string albumToDelete);
  /*
   * Description:
   *   Removes the cd with artist artistToDelete and album albumToDelete
   *   from the list.
   *
   * Post-conditions:
   *   The matching cd is deleted from the list and deallocated, if it exists.
   */
};

#endif //COLLECTION_H
