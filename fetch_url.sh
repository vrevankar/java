if [ "$#" -ne 3 ]; then
  echo 'usage: sh fetch_url url request_count thread_count'
  exit 1
fi

num_regex='^[0-9]+$'
if echo $2 | egrep -q $num_regex; then
  if echo $3 | egrep -q $num_regex; then
     java -cp . com/vrevankar/java/sample/multithreading/printUrl/PrintUrlTest $1 $2 $3
  else
    echo 'Please enter valid nuberic thread count'
    exit 1
  fi
else
  echo 'Please enter valid numeric request count'
  exit 1
fi

