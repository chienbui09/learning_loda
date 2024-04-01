# ForkJoinPool
- Refer to : [ForkJoinPool](https://gpcoder.com/3573-su-dung-fork-join-framework-voi-forkjoinpool-trong-java/)

- **Mục đích**: Tăng tốc độ xử lý song song bằng cách chia nhỏ các task, sử dụng tất cả các lõi có sẵn.
- **Phương pháp**:
  - **B1**: Chia nhỏ các task(fork), tiếp tục đệ quy, chia nhỏ các nhiệm vụ thành các nhiệm vụ nhỏ hơn 
---> đến mức có thể thưcj hiện không đồng bộ.
  - **B2**: sau khi fork, sẽ join các kết của của nhiệm vụ ---> 1 kết quả duy nhất.

- ForkJoin !=  executorService: ForkJoin phân các các tác vụ cho các luồng thực thi trong Thread Pool, sử dung thuật
toán work-stealing. Các luồng sẽ thưucj thi công việc trên một bộ xử lý riêng biệt, khi xong, nó sẽ check và xử lý các tác
vụ của các luồng đang bận

- **Các lớp Chính**:
    - ForkJoinTask<V>: Abstract class định nghĩa task sẽ được thực thi trong 1 ForkJoinPool
    - ForkJoinPool: Thread pool quản lý việc thực thi các forkJoinTask
    - RecursiveAction: Class con của ForkJoinTask, thực thi mà không trả lại kết quả
    - RecursiveTask<V>: Class con của ForkJoinTask, có trả lại kết quả.
  
  `ForkJoinPool forkJoinPool = new ForkJoinPool(numOfProcessor);`