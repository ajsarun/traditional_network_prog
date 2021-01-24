
/* primes.x */
/* Data structures and server info for RPC call of find_primes() */

const MAXPRI = 1000;       /* max number of primes collected */

struct range {     /* range for primes searching */
  int min;
  int max;
};

struct pinfo {     /* collected primes */
  int primes<MAXPRI>;
  int num_primes;
};

/* server information */
program PRIMEPROG {
  version PRIMEVERS {
    pinfo FIND_PRIMES(range) = 1;
  } = 1;           /* the version number */
} = 0x2000009a;    /* the program number */

