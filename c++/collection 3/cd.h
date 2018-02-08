/*
 * File: cd.h
 * Name: Cody Robertson and  Nisha Patel
 * Date: 8/29/15
 * Description: A CD struct for use in the collection class.
 */

#ifndef CD_H
#define CD_H

struct cd {
  std::string artist;
  std::string title;
  int total_tracks;
  int year;
  float price;
  std::string genre;
};

#endif
