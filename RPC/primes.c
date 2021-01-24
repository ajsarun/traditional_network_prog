
/* primes.c */

#include <stdio.h>
#include <stdlib.h>   /* for atoi() */

#define MAXPRI 1000       /* max number of primes collected */

/* I/O structures for find_primes() */
struct range {     /* range for primes searching */
  int min, max;
};

struct pinfo {     /* collected primes */
  int primes[MAXPRI];
  int num_primes;
};


struct pinfo find_primes(struct range r);
int isprime(int n);
void report_results(struct pinfo pi);


int main(int argc, char *argv[])
{
  struct range r;
  struct pinfo pi;

  if (argc != 3) {
    fprintf(stderr, "Usage: primes <min> <max>\n");
    exit(1);
  }
  r.min = atoi(argv[1]);   /* no error checking here */
  r.max = atoi(argv[2]);

  pi = find_primes(r);
  report_results(pi);

  return 0;
}


struct pinfo find_primes(struct range r)
/* Collect primes between r.min and r.max */
{
  struct pinfo pi;
  int i;

  if (r.min > r.max)
    pi.num_primes = -1;
  else {
    pi.num_primes = 0;
    for (i = r.min; i <= r.max; i++)
      if (isprime(i)) {
        if (pi.num_primes < MAXPRI)
          pi.primes[pi.num_primes] = i;
        pi.num_primes++;
      }
  }
  return pi;
}


int isprime(int n)
{
  int i;
  for (i = 2; i*i <= n; i++)
    if ((n % i) == 0)
      return 0;
  return 1;
}


void report_results(struct pinfo pi)
{
  int i;

  if (pi.num_primes == -1)
    fprintf(stderr, "range error\n");
  else {
    if (pi.num_primes > MAXPRI) {
      fprintf(stderr, "Too many primes for collection: %d\n", 
                                                 pi.num_primes);
      pi.num_primes = MAXPRI;
    }
    for (i = 0; i < pi.num_primes; i++) {
      printf("%5d", pi.primes[i]);
      if (((i+1)%10) == 0)
        putchar('\n');
    }
    putchar('\n');
  }
}

