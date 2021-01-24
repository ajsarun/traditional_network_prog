
/* primes_cli.c */

#include <stdio.h>
#include <stdlib.h>     /* for atoi() */
#include "primes.h"


pinfo primeprog_1(char *host, range r);
void report_results(pinfo pi);


int main(int argc, char *argv[])
{
  range r;
  pinfo pi;

  if (argc != 4) {
    fprintf(stderr, "Usage: primes <host> <min> <max>\n");
    exit(1);
  }
  r.min = atoi(argv[2]);   /* no error checking here */
  r.max = atoi(argv[3]);

  pi = primeprog_1(argv[1], r);
  report_results(pi);

  return 0;
}


pinfo primeprog_1(char *host, range r)
{
  CLIENT *clnt;
  pinfo  *result_1, ans;

#ifndef	DEBUG
  clnt = clnt_create(host, PRIMEPROG, PRIMEVERS, "netpath");
  if (clnt == (CLIENT *) NULL) {
    clnt_pcreateerror(host);
    exit(1);
  }
#endif	/* DEBUG */

  ans.num_primes = -2;    /* denotes no answer */
  result_1 = find_primes_1(&r, clnt);
  if (result_1 == (pinfo *) NULL)
    clnt_perror(clnt, "call failed:");
  else
    ans = *result_1;

#ifndef DEBUG
  clnt_destroy(clnt);
#endif          /* DEBUG */
  return ans; 
}


void report_results(pinfo pi)
{
  int i;

  if (pi.num_primes == -2)             /* new error */
    fprintf(stderr, "RPC error\n");
  else if (pi.num_primes == -1)
    fprintf(stderr, "range error\n");
  else {
    if (pi.num_primes > MAXPRI) {
      fprintf(stderr, "Too many primes for collection: %d\n",
                                                 pi.num_primes);
      pi.num_primes = MAXPRI;
    }
    for (i = 0; i < pi.num_primes; i++) {
      printf("%5d", pi.primes.primes_val[i]);     /* change */
      if (((i+1)%10) == 0)
        putchar('\n');
    }
    putchar('\n');
  }
}

