
/* primes_serv.c */
#include "primes.h"


pinfo *find_primes_1_svc(range *rp, struct svc_req *rqstp);
int isprime(int n);


pinfo *find_primes_1_svc(range *rp, struct svc_req *rqstp)
{
  static pinfo pi;
  static int parray[MAXPRI];
  int i;

  if (rp->min > rp->max)
    pi.num_primes = -1;
  else {
    pi.num_primes = 0;
    for (i = rp->min; i <= rp->max; i++)
      if (isprime(i)) {
        if (pi.num_primes < MAXPRI)
          parray[pi.num_primes] = i;   /* change to access */
        pi.num_primes++;
      }
  }
  pi.primes.primes_len = (pi.num_primes < MAXPRI) ? pi.num_primes : MAXPRI;
  pi.primes.primes_val = parray;
  return(&pi);
}


int isprime(int n)
{
  int i;
  for (i = 2; i*i <= n; i++)
    if ((n % i) == 0)
      return 0;
  return 1;
}

