public class Pruebas {

    public ResponseEntity<List<Producto>> getProduct() {
        List<Producto> productos = todoRepository.getProduct();
        return new ResponseEntity<>(productos , HttpStatus.ok);
    }
}
